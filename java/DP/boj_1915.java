package DP;
import java.io.*;
import java.util.*;
public class boj_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
        int[][] dp = new int[row+1][col+1];
        for(int r = 1; r <= row; r++){
            String s = br.readLine();
            for(int c = 1; c <= col; c++){
                if(s.charAt(c-1) == '1'){
                    dp[r][c] = 1;
                }
            }
        }
        int max = 0;
        for(int r = 1; r <= row; r++){
            for(int c = 1; c <= col; c++){
                if(dp[r][c] == 1){
                    dp[r][c] = Math.min(dp[r-1][c-1], Math.min(dp[r][c-1],dp[r-1][c]))+1;
                    max = Math.max(max,dp[r][c]);
                }
            }
        }
        System.out.println(max*max);
    }
}
