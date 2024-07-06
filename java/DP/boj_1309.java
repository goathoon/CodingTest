package DP;
import java.io.*;
import java.util.*;
public class boj_1309 {
    public static void main(String[] args) {
        final long mod = 9901;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N+1];

        if(N == 1){
            System.out.println(3);
            return;
        }

        if(N == 2){
            System.out.println(7);
            return;
        }
        dp[1] = 3;
        dp[2] = 7;
        for(int n = 3; n <= N; n++){
            dp[n] = (dp[n-1] * 2 + dp[n-2]) % mod;
        }
        System.out.println(dp[N]);
    }
}
