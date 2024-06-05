package DFS_BFS;

import java.io.*;
import java.util.*;

public class EX_음료수얼려먹기_2 {
    static int[] drow = {1,0,-1,0};
    static int[] dcol = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
        int[][] grid = new int[row][col];
        for (int r = 0; r < row; r++) {
            String s  = br.readLine();
            for(int c = 0; c < col; c++){
                grid[r][c] = Character.getNumericValue(s.charAt(c));
            }
        }

        int ans = 0;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 0){
                    dfs(r,c,grid);
                    ans ++;
                }
            }
        }
        System.out.println(ans);
    }
    public static void dfs(int row, int col, int[][] grid){
        grid[row][col] = 1;
        for(int i = 0; i < 4; i++){
            int nextR = row + drow[i];
            int nextC = col + dcol[i];
            if(nextR < 0 || nextR >= grid.length || nextC < 0 || nextC >= grid[0].length) continue;
            if(grid[nextR][nextC] == 1) continue;
            dfs(nextR,nextC,grid);
        }
    }
}
