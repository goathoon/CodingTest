package DP;
import java.io.*;
import java.util.*;
public class boj_18353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;
        for(int i = 1; i < N; i++){
//            if(arr[i] < arr[i-1]){
//                dp[i] = dp[i-1] + 1;
//            }
//            else{
//                int max = 0;
//                for(int j = i-1; j >= 0; j--){
//                    if(arr[j] > arr[i]){
//                        max = Math.max(dp[j],max);
//                    }
//                }
//                dp[i] = max + 1;
//            }\
            int max = 0;
            for(int j = i-1; j >= 0; j--){

                if(arr[j] > arr[i]){
                    max = Math.max(dp[j],max);
                }
            }
            dp[i] = max + 1;
        }
        int maxLen = 0;
        for(int x : dp){
            maxLen = Math.max(x,maxLen);
        }
        System.out.println(N-maxLen);
    }
}
