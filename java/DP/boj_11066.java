package DP;

import java.io.*;
import java.util.*;

public class boj_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 0; tc <TC; tc++){
            int cnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[][] dp = new int[cnt+1][cnt+1];
            int[] sum = new int[cnt+1];
            for(int c = 1; c <= cnt; c++){
                sum[c] = sum[c-1] + Integer.parseInt(st.nextToken());
            }
            for(int diff = 1; diff < cnt; diff++){
                for(int i = 1; i <= cnt; i ++){
                    int end = i + diff;
                    if(end > cnt) continue;
                    dp[i][end] = Integer.MAX_VALUE;
                    for(int mid = i; mid < end; mid++){
                        dp[i][end] = Math.min(dp[i][end],dp[i][mid] + dp[mid+1][end] + sum[end]-sum[i-1]);
                    }
                }
            }
            System.out.println(dp[1][cnt]);

        }
    }
}
