package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int n = 1; n <= N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[N+1][3];
        for(int n = 1; n < dp.length; n++){
            int beforeMax = dp[n-1][0];
            for(int choice = 1; choice <= 2; choice++){
                beforeMax = Math.max(dp[n-1][choice], beforeMax);
            }
            dp[n][0] = beforeMax;

            dp[n][1] = dp[n-1][0] + arr[n];
            dp[n][2] = dp[n-1][1] + arr[n];
        }
        int ans = 0;
        for(int c = 0; c < 3; c++){
            ans = Math.max(ans, dp[N][c]);
        }
        System.out.println(ans);
    }
}
