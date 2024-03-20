package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15486 {
    public static void main(String[] args) throws IOException {
        class Work{
            int time;
            int cost;
            Work(int time, int cost){
                this.time = time;
                this.cost = cost;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Work[] works = new Work[N+1];
        works[0] = new Work(0,0);
        int[] dp = new int[N+2];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            works[i] = new Work(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        int ans = 0;
        for(int i = 1; i <= N; i++){
            Work curW = works[i];
            int time = curW.time;
            int cost = curW.cost;
            dp[i] = Math.max(dp[i-1],dp[i]);
            if(i+time <= N+1){
                dp[i+time] = Math.max(dp[i] + cost, dp[i+time]);
                ans = Math.max(ans,dp[i+time]);
            }
        }
        System.out.println(ans);
    }
}
