package DP;
import java.io.*;
import java.util.*;
public class boj_2602 {
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
        int up = dfs(0,0,0);
        int down = dfs(0,1,0);
        System.out.println(up+down);
    }
    public static int dfs(int sIdx, int turn, int turnIdx){
        if(sIdx == s.length()){
            return 1;
        }
        if(turnIdx >= a.length()) return 0;
        if(dp[turn][sIdx][turnIdx] >= 0) return dp[turn][sIdx][turnIdx];
        int cnt = 0;
        if(turn == 1){
            if(s.charAt(sIdx) == a.charAt(turnIdx)){
                cnt += dfs(sIdx+1,0,turnIdx+1);
            }
            cnt += dfs(sIdx,1,turnIdx+1);

        }
        else{
            if(s.charAt(sIdx) == b.charAt(turnIdx)){
                cnt += dfs(sIdx+1, 1, turnIdx+1);
            }
            cnt += dfs(sIdx,0,turnIdx+1);

        }
        return dp[turn][sIdx][turnIdx] = cnt;
    }
}
