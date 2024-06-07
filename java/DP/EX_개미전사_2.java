package DP;
import java.io.*;
import java.util.*;
public class EX_개미전사_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];
        for(int i = 2; i <= N; i++){
            dp[i] = Math.max(dp[i-2]+arr[i],dp[i-1]);
        }
        System.out.println(dp[N]);
    }
}
