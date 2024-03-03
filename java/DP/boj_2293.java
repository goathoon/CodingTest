package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_2293 {

    class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int[] dp = new int[K + 1];
            for (int i = 0; i < N; i++) {
                int coin = Integer.parseInt(br.readLine());
                arr[i] = coin;
            }
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= K; j++) {
                    if (j - arr[i] >= 0) {
                        dp[j] += dp[j - arr[i]];
                    }
                }
            }
            System.out.println(dp[K]);

        }
    }
}
