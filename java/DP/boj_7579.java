package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_7579 {
//    static long[] dp;
//    static int[] memory;
//    static int[] cost;
//    static long answer = Long.MAX_VALUE;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine(), " ");
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        dp = new long[M];
//        Arrays.fill(dp,Long.MAX_VALUE);
//        memory = new int[N];
//        cost = new int[N];
//        st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i<N; i++){
//            memory[i] = Integer.parseInt(st.nextToken());
//        }
//        st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i < N; i++){
//            cost[i] = Integer.parseInt(st.nextToken());
//        }
//        backTracking(0,0,0);
//        System.out.println(answer);
//    }
//    static void backTracking(int totalMemory, long totalCost, int curIdx){
//        if(totalMemory + memory[curIdx] >= dp.length){
//            answer = Math.min(answer, totalCost + cost[curIdx]);
//            return;
//        }
//        dp[totalMemory] = Math.min(dp[totalMemory],totalCost);
//        if (dp[totalMemory] != totalCost){
//            return;
//        }
//        for(int i = curIdx; i < memory.length; i ++){
//            if (i + 1 == memory.length) continue;
//            backTracking(totalMemory + memory[i], totalCost + cost[i], i+1);
//        }
//    }

    static int[] dp;
    static int[] memory;
    static int[] cost;
    static long answer = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dp = new int[10001];
        memory = new int[N];
        cost = new int[N];
        StringTokenizer memories = new StringTokenizer(br.readLine(), " ");
        StringTokenizer costs = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(memories.nextToken());
            cost[i] = Integer.parseInt(costs.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 10000; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j - cost[i]] + memory[i], dp[j]);
            }
        }
        for (int i = 0; i< 10001; i++){
            if(dp[i]>=M){
                System.out.println(i);
                return;
            }
        }
    }
}
