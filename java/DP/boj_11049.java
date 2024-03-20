package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11049 {
    static class Matrix{
        int row;
        int col;
        Matrix(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static List<Matrix> list;
    static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        list.add(new Matrix(0,0));
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Matrix(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        dp = new int[N+1][N+1];
        if(N==1){
            System.out.println(0);
            System.exit(0);
        }
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        System.out.println(dfs(1,N));

    }
    public static int dfs(int start, int end){
        if(start == end) return 0;
        if(dp[start][end] != Integer.MAX_VALUE){
            return dp[start][end];
        }
        if(start + 1 == end){
            return dp[start][end] = list.get(start).row * list.get(start).col * list.get(end).col;
        }
        for(int i = start; i < end; i++){
            dp[start][end] = Math.min(dfs(start,i) + dfs(i+1,end) + list.get(start).row * list.get(i+1).row * list.get(end).col, dp[start][end]);
        }
        return dp[start][end];
    }
}
