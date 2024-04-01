package DP;

import java.io.*;
import java.util.*;

public class boj_2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr =new int[N];
        int[] dp = new int[N];
        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(br.readLine());
            dp[n] = 1;
        }
        int maxLen = 0;
        for(int i = 0; i < N; i++){
            for(int j = i-1; j >= 0; j--){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                    maxLen = Math.max(dp[i],maxLen);
                }
            }
        }
        System.out.println(N-maxLen);
    }
}
