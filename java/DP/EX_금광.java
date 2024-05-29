package DP;
import java.io.*;
import java.util.*;
public class EX_금광 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] grid;
        int[][] dp;
        for(int tc = 0 ; tc < T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
            grid = new int[row][col];
            dp = new int[row][col];
            st = new StringTokenizer(br.readLine(), " ");
            for(int r = 0; r < row; r++){
                for(int c = 0; c < col; c++){
                    dp[r][c] = grid[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            for(int c = 1; c < col; c++){
                for(int r = 0; r < row; r++){
                    dp[r][c] = Math.max(dp[r][c-1] + grid[r][c], dp[r][c]);
                    if(r-1 >= 0){
                        dp[r][c] = Math.max(dp[r-1][c-1] + grid[r][c], dp[r][c]);
                    }
                    if(r+1 < row){
                        dp[r][c] = Math.max(dp[r+1][c-1] + grid[r][c], dp[r][c]);
                    }
                }
            }
            int ans = 0;
            for(int r = 0; r < row; r++){
                ans = Math.max(dp[r][col-1],ans);
            }
            System.out.println(ans);
            grid = null;
            dp = null;
        }
    }
}
