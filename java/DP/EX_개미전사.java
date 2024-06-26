package DP;
import java.io.*;
import java.util.*;
public class EX_개미전사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];
        dp[2] = Math.max(arr[1],arr[2]);

        for(int i = 3; i < arr.length; i++){
            dp[i] = Math.max(dp[i-2] + arr[i],dp[i-1]);
        }
        System.out.println(dp[dp.length-1]);
    }
}
