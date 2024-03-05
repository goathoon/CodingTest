package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1520 {
    /** Thanks To
     * https://velog.io/@jxlhe46/%EB%B0%B1%EC%A4%80-1520%EB%B2%88.-%EB%82%B4%EB%A6%AC%EB%A7%89%EA%B8%B8
     */
    static int[][] grid;
    static int[][] dp;
    static int[] drow = new int[]{1,0,-1,0};
    static int[] dcol = new int[]{0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        grid = new int[row][col];
        dp = new int[row][col];
        for(int r = 0; r < row; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < col; c++){
                grid[r][c] = Integer.parseInt(st.nextToken());
                dp[r][c] = -1;
            }
        }
        dp[row-1][col-1] = 1;
        System.out.println(dfs(0,0));
    }
    public static int dfs(int startRow, int startCol){
        if(dp[startRow][startCol] != -1){
            return dp[startRow][startCol];
        }
        dp[startRow][startCol] = 0;
        for(int i = 0; i < 4; i++){
            int nextRow = startRow+drow[i];
            int nextCol = startCol+dcol[i];
            if(nextRow < 0 || nextRow >= dp.length || nextCol < 0 || nextCol >= dp[0].length || grid[startRow][startCol] <= grid[nextRow][nextCol]){
                continue;
            }
            dp[startRow][startCol] += dfs(nextRow,nextCol);
        }
        return dp[startRow][startCol];
    }
}
