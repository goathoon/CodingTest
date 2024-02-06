package DP.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class boj_11053 {
    //Bottom-Up
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
    //Top-Down
    class Main2{
        static Integer []dp;
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[N];
            dp = new Integer [N];
            for(int i = 0 ; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < N; i ++){
                dfs(i,arr);
            }
            int ans = 0;
            for(int i = 0; i < N; i++){
                ans = Math.max(ans,dp[i]);
            }
            System.out.println(ans);
        }
        public static int dfs(int idx, int[] arr){
            if(Objects.isNull(dp[idx])){
                dp[idx] = 1;
                for(int i = 0; i < idx; i ++){
                    if(arr[idx] > arr[i]){
                        dp[idx]  = Math.max(1+dfs(i,arr),dp[idx]);
                    }
                }
            }
            return dp[idx];
        }
    }
}
