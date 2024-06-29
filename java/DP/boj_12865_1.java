package DP;
import java.io.*;
import java.util.*;
public class boj_12865_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K+1][N+1];
        for(int n = 1; n <= N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            for(int weight = 1; weight <= K; weight++){
                if(weight >= w) {
                    dp[weight][n] = Math.max(dp[weight - w][n - 1] + v, dp[weight][n - 1]);
                }
                else{
                    dp[weight][n] = dp[weight][n-1];
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}
