package DP;

import java.io.*;
import java.util.*;

public class boj_12865 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[][] things = new int[N+1][2];
        for(int n = 1; n <= N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            things[n][0] = Integer.parseInt(st.nextToken());
            things[n][1] = Integer.parseInt(st.nextToken());
        }
        // K는 무게, N은 물건 개수
        int[][] dp = new int[K+1][N+1];

        // i 번째 물건까지 선택을 완료하였을 때, j 무게 까지 담을 수 있는 최대 가치합
        for(int i = 1; i <= N; i++){
            int weight = things[i][0];
            int value = things[i][1];
            for(int j = 1; j <= K; j++){
                // 현재 무게가 i번째 물건으로 채울 수 있는 상황일 때
                if (j >= weight){
                    // 왼쪽항은, i번째 물건을 선택하지 않았을때
                    // 오른쪽항은 i번째 물건을 선택했을때
                    dp[j][i] = Math.max(dp[j][i-1], value+dp[j-weight][i-1]);
                }
                else{
                    dp[j][i] = dp[j][i-1];
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}
