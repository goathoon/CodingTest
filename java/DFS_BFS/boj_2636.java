package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2636 {
    static int[][] grid;
    static boolean[][] visited;
    static int[] drow = {-1,0,1,0};
    static int[] dcol = {0,-1,0,1};
    static int cheese = 0;
    static boolean[][] melt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        grid = new int[R][C];
        visited = new boolean[R][C];
        melt = new boolean[R][C];
        cheese = 0;
        for(int r = 0; r < R; r++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < C; c++){
                grid[r][c] = Integer.parseInt(st.nextToken());
                if(grid[r][c] == 1){
                    cheese++;
                }
            }
        }
        int time = 0;
        if(cheese == 0){
            System.out.println(0);
            System.out.println(0);
            return;
        }
        while(true) {
            time++;
            boolean isEnd = false;
            int beforeCheese = cheese;
            dfs(0,0);
            for(int r = 0 ; r < R; r++){
                for(int c = 0; c< C; c++){
                    visited[r][c] = false;
                    if(melt[r][c]){
                        grid[r][c] = 0;
                    }
                    melt[r][c] = false;
                }
            }
            if(cheese == 0) isEnd = true;
            if(isEnd){
                System.out.println(time);
                System.out.println(beforeCheese);
                break;
            }
        }
    }
    public static void dfs(int row, int col){
        visited[row][col] = true;
        for(int i = 0; i < 4; i++){
            int nextRow = row+drow[i];
            int nextCol = col+dcol[i];
            if(nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length ){
                if(grid[nextRow][nextCol] == 1){
                    if(melt[nextRow][nextCol]) continue;
                    cheese--;
                    melt[nextRow][nextCol] = true;
                }
                else{
                    if(!visited[nextRow][nextCol]) {
                        dfs(nextRow,nextCol);
                    }
                }
            }
        }
    }
}
