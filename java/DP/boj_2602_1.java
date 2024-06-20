package DP;
import java.io.*;
import java.util.*;
public class boj_2602_1 {
    static int[][][] dp;
    static String s;
    static String a;
    static String b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        a = br.readLine();
        b = br.readLine();
        dp = new int[2][s.length()][a.length()];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < s.length(); j++){
                for(int k = 0; k < a.length(); k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        System.out.println(dfs(0,0,0) + dfs(0,0,1));

    }
    public static int dfs(int sIdx, int curIdx, int dir){
        if(sIdx == s.length()){
            return 1;
        }
        if(curIdx == a.length()) return 0;
        if(dp[dir][sIdx][curIdx] != -1) return dp[dir][sIdx][curIdx];

        int val = 0;
        //위쪽
        if(dir == 0){
            if(s.charAt(sIdx) == a.charAt(curIdx)){
                val += dfs(sIdx+1,curIdx+1,1);
            }
            val += dfs(sIdx, curIdx+1,0);
        }
        else{
            if(s.charAt(sIdx) == b.charAt(curIdx)){
                val += dfs(sIdx+1, curIdx+1, 0);
            }
            val += dfs(sIdx,curIdx+1,1);
        }
        return dp[dir][sIdx][curIdx] = val;
    }
}
