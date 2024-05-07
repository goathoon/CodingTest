package DP;

import java.io.*;
import java.util.*;

public class boj_2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[301];
        for (int n = 1; n <= N; n++) {
            stairs[n] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[301];
        dp[1] = stairs[1];
        dp[2] = stairs[1]+stairs[2];
        for(int i = 3; i <= N; i++){
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i]);
            dp[i] = Math.max(dp[i-3] + stairs[i-1]+stairs[i], dp[i]);
        }
        System.out.println(dp[N]);
    }
    class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] stairs = new int[N + 1];
            for (int n = 1; n <= N; n++) {
                stairs[n] = Integer.parseInt(br.readLine());
            }
            // 0번째 열은, 연속적으로 올라가지 않은 경우에 N번째 계단의 최대 점수
            // 1번째 열은, 연속적으로 올라간 경우에 N번째 계단의 최대 점수
            int[][] dp = new int[N + 1][2];
            dp[1][0] = stairs[1];

            for (int n = 2; n <= N; n++) {
                dp[n][0] = Math.max(dp[n - 2][0] + stairs[n], dp[n][0]);
                dp[n][0] = Math.max(dp[n - 2][1] + stairs[n], dp[n][0]);
                dp[n][1] = Math.max(dp[n - 1][0] + stairs[n], dp[n][1]);
            }
            System.out.println(Math.max(dp[N][0], dp[N][1]));
        }
    }
}
