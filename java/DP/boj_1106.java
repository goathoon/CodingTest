package DP;

import java.io.*;
import java.util.*;

public class boj_1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        int[][] cities = new int[N][2];
        int[] dp = new int[C+1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            int cost = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            cities[n][0] = cost;
            cities[n][1] = num;
        }
        for(int[] city : cities){
            int cost = city[0];
            int num = city[1];
            for(int i = 0; i < C; i++) {
                if (dp[i] != Integer.MAX_VALUE) {
                    int curCost = dp[i];
                    int curNum = i;
                    while (true) {
                        curCost += cost;
                        curNum += num;
                        if (curNum >= C) {
                            dp[C] = Math.min(dp[C], curCost);
                            break;
                        }
                        dp[curNum] = Math.min(dp[curNum], curCost);
                    }
                }
            }
        }
        System.out.println(dp[C]);
    }
}
