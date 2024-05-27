package DFS_BFS;

import java.io.*;
import java.util.*;

public class EX_음료수얼려먹기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
        char[][] grid = new char[row][col];
        for (int r = 0; r < row; r++) {
            grid[r] = br.readLine().toCharArray();
        }
        int ans = 0;

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(dfs(r,c,grid)){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
    public static boolean dfs(int row, int col, char[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ){
            return false;
        }
        if(grid[row][col] == '0'){
            // 방문 처리를 grid자체에서 변환한다.
            grid[row][col] = '1';
            dfs(row-1,col,grid);
            dfs(row,col-1,grid);
            dfs(row+1,col,grid);
            dfs(row,col+1,grid);
            return true;
        }
        return false;
    }
    class MySol {
        public static int[] drow = {1, 0, -1, 0};
        public static int[] dcol = {0, 1, 0, -1};

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
            char[][] grid = new char[row][col];
            boolean[][] visit = new boolean[row][col];
            for (int r = 0; r < row; r++) {
                grid[r] = br.readLine().toCharArray();
            }
            int ans = 0;
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (visit[r][c] || grid[r][c] == '1') continue;
                    dfs(r, c, grid, visit);
                    ans++;
                }
            }
            System.out.println(ans);
        }

        public static void dfs(int row, int col, char[][] grid, boolean[][] visit) {
            visit[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int nextRow = row + drow[i];
                int nextCol = col + dcol[i];
                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length || grid[nextRow][nextCol] == '1' || visit[nextRow][nextCol]) {
                    continue;
                }
                dfs(nextRow, nextCol, grid, visit);
            }
        }
    }
}
