package DP;

import java.io.*;
import java.util.*;

public class boj_12865 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        // K는 무게, N은 물건 개수
        int[][] dp = new int[K+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
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
