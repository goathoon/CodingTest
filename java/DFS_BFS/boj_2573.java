package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2573{
    static int[][] grid;
    static int[][] melt;
    static boolean[][] visited;
    static int[] drow = {1,0,-1,0};
    static int[] dcol = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        grid = new int[row][col];
        melt = new int[row][col];
        visited = new boolean[row][col];

        for(int r = 0; r < row; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < col; c++){
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        while(true) {
            for(int r = 0; r < row; r++){
                for(int c = 0; c < col; c++){
                    visited[r][c] = false;
                    melt[r][c] = 0;
                }
            }
            boolean isEnd = true;
            int setCnt = 0;
            for (int r = 1; r < row - 1; r++) {
                for (int c = 1; c < col - 1; c++) {
                    if (grid[r][c] != 0) {
                        isEnd=false;
                        if(!visited[r][c]){
                            dfs(r,c);
                            setCnt++;
                        }
                        if(grid[r][c] <= melt[r][c]){
                            grid[r][c] = 0;
                        }
                        else{
                            grid[r][c] -= melt[r][c];
                        }
                    }

                }
            }
            if(setCnt>=2){
                System.out.println(ans);
                return;
            }
            if(isEnd) {
                System.out.println(0);
                return;
            }
            ans++;

        }
    }
    public static void dfs(int row, int col){
        visited[row][col] = true;
        for(int i = 0; i < 4; i++){
            int nextRow = row + drow[i];
            int nextCol = col + dcol[i];
            if(grid[nextRow][nextCol] == 0){
                melt[row][col] += 1;
            }
            else{
                if(!visited[nextRow][nextCol]) {
                    dfs(nextRow,nextCol);
                }
            }
        }
    }
}
