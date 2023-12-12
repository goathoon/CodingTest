package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            int cnt = Integer.parseInt(br.readLine());
            int[] coin = new int[cnt];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < cnt; j++){
                coin[j] = Integer.parseInt(st.nextToken());
            }
            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[target+1];
            dp[0] = 1;
            for(int c : coin){
                for(int m = c; m <= target; m++){
                    dp[m] += dp[m - c];
                }
            }
            System.out.println(dp[target]);
        }
    }
}
