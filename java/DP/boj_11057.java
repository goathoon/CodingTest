package DP;

import java.io.*;
import java.util.*;
public class boj_11057 {
    static long [][] dp;
    static final long mod = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new long[N+1][10];
        for(int i = 0; i <= 9; i++){
            dp[1][i] = 1;
        }
        for(int n = 2; n <= N; n++){
            for(int lastNum = 0; lastNum <= 9; lastNum ++){
                long val = 0;
                for(int beforeNum = lastNum; beforeNum >= 0; beforeNum--){
                    val += dp[n-1][beforeNum];
                    val %= mod;
                }
                dp[n][lastNum] = val;
            }
        }
        long ans = 0;
        for(int i = 0; i <= 9; i++){
            ans += dp[N][i];
        }
        System.out.println(ans % mod);
    }
}

