package DP;

import java.util.*;
import java.io.*;
class boj_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N;i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            dp[i] = 1;
        }
        int maxIndex = 0;
        for(int i = 1; i < N; i++){
            for(int j = i-1; j >= 0; j --){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                    if(dp[i] == dp[j]+1){
                        if(dp[maxIndex] < dp[i]){
                            maxIndex = i;
                        }
                    }
                }
            }
        }
        list.add(arr[maxIndex]);
        int curCnt = dp[maxIndex];
        for(int i = maxIndex-1; i >= 0; i--){
            if(arr[maxIndex] > arr[i] && dp[maxIndex]-1 == dp[i]){
                list.add(arr[i]);
                maxIndex = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = curCnt -1; i >= 0; i--){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(curCnt);
        System.out.println(sb);
    }
}