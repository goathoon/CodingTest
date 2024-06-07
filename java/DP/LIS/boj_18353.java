package DP.LIS;
import java.io.*;
import java.util.*;
public class boj_18353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp,1);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 1;
        for(int i = 1; i < N; i++){
            for(int j = i-1; j >= 0; j --){
                if(arr[i] < arr[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                    max = Math.max(dp[i],max);
                }
            }
        }
        System.out.println(N-max);
    }
}
