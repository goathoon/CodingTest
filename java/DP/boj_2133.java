package DP;

import java.util.Scanner;

public class boj_2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N+1];
        if(N>=2) {
            dp[2] += 3;
        }
        if(N>=4) {
            dp[4] += dp[4 - 2] * dp[2];
            dp[4] += 2;
        }
        for(int i = 6; i <= N; i+=2){
            dp[i] += 2;
        }
        for(int i = 6; i <= N; i++){
            dp[i] += dp[i-2] * dp[2];
            dp[i] += dp[i-4] * 2;
            for(int j = 6; j <= i; j+=2){
                dp[i] += dp[i-j] * 2;
            }
        }
        System.out.println(dp[N]);
    }
}
