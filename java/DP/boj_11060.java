package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] stairs =new int[cnt];
        int[] dp = new int[cnt];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < cnt; i++){
            if (dp[i] == Integer.MAX_VALUE) continue;
            stairs[i] = Integer.parseInt(st.nextToken());
            for(int move = stairs[i]; move > 0; move --){
                if(i + move < cnt){
                    dp[i+move] = Math.min(dp[i] + 1, dp[i+move]);
                }
            }
        }
        int answer = dp[cnt-1] == Integer.MAX_VALUE ? -1 : dp[cnt-1];
        System.out.println(answer);

    }
}
