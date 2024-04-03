package DP;

import java.io.*;
import java.util.*;

public class boj_1937 {
    static int[][] grid;
    static int[][] dp;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        dp = new int[N][N];
        for(int r = 0; r < N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < N; c++){
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){

            }
        }
        int ans = 0;
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                ans = Math.max(dfs(r,c),ans);
            }
        }
        System.out.println(ans);
    }
    public static int dfs(int r, int c){
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, -1, 0, 1};
        boolean isEnd = true;
        for(int i = 0; i < 4; i++){
            int nextRow = r + drow[i];
            int nextCol = c + dcol[i];
            if(nextRow < 0 | nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length || grid[nextRow][nextCol] <= grid[r][c]) continue;

            isEnd = false;
            if(dp[nextRow][nextCol] != 0){
                dp[r][c] = Math.max(dp[r][c], dp[nextRow][nextCol] + 1);
            }
            else{
                dp[r][c] = Math.max(dp[r][c], dfs(nextRow,nextCol) + 1);
            }
        }
        return isEnd ? 1 : dp[r][c];
    }
}
