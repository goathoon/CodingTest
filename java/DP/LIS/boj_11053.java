package DP.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11053 {
    class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[N];
            int[] dp = new int[N];
            for(int i = 0 ; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i] = 1;
            }
            for(int i = 1; i < N; i++){
                for(int j = i-1; j >= 0; j--){
                    if(arr[i] > arr[j]){
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
            int ans = 0;
            for(int i = 0; i < N; i++){
                ans = Math.max(dp[i],ans);
            }
            System.out.println(ans);
        }
    }
}
