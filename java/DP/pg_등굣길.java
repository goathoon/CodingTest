package DP;
import java.util.*;
public class pg_등굣길 {
    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int mod = 1_000_000_007;
            int[][] grid = new int[n+1][m+1];
            for(int[] p : puddles){
                if(p.length >= 2){
                    grid[p[1]][p[0]] = -1;
                }
            }
            grid[1][1] = 1;
            for(int r = 1; r <= n; r++){
                for (int c = 1; c <= m; c++){
                    if(grid[r][c] == -1) continue;
                    if(grid[r-1][c] > 0) grid[r][c] += grid[r-1][c] % mod;
                    if(grid[r][c-1] > 0) grid[r][c] += grid[r][c-1] % mod;
                    grid[r][c] %= mod;
                }
            }
            return grid[n][m] % mod;
        }
    }
    class Solution2 {
        static int[][] grid;
        static int mod = 1_000_000_007;
        public int solution(int m, int n, int[][] puddles) {
            grid = new int[n+1][m+1];
            for(int[] p : puddles){
                if(p.length >= 2){
                    grid[p[1]][p[0]] = -1;
                }
            }
            grid[n][m] = 1;
            return dfs(1,1);
        }
        public int dfs(int row, int col){
            if(grid[row][col] != 0){
                return grid[row][col];
            }
            if(row+1 < grid.length && grid[row+1][col] != -1) {
                grid[row][col] += dfs(row+1,col) % mod;
            }
            if(col+1 < grid[0].length && grid[row][col+1] != -1){
                grid[row][col] += dfs(row,col+1) % mod;
            }
            grid[row][col] %= mod;
            return grid[row][col];
        }
    }
}
