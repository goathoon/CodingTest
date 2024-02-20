package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14503 {
    static int answer = 0;
    static boolean[][] cleanAll;
    static Point[] moves = {new Point(-1,0), new Point(0,1), new Point(1,0), new Point(0,-1)};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int startDir = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][M];
        cleanAll = new boolean[N][M];
        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < M; c++){
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(startR,startC,startDir,grid);
        for(int i = 0; i< N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] == 2){
                    answer ++;
                }
            }
        }
        System.out.println(answer);
    }
    static void dfs(int row, int col, int dir, int[][] grid){
        //해당 위치 청소
        grid[row][col] = 2;
        int cnt = 0;
        while(cnt < 4){
            dir--;
            if(dir == -1){
                dir = 3;
            }
            Point nextPoint = moves[dir];
            int nextRow = nextPoint.row + row;
            int nextCol = nextPoint.col + col;
            if(0 <= nextRow && nextRow < grid.length && 0 <= nextCol && nextCol < grid[0].length){
                if(grid[nextRow][nextCol] == 0){
                    dfs(nextRow,nextCol,dir,grid);
                    return;
                }
            }
            cnt++;
        }
        int nextDir;
        if(dir >= 2){
            nextDir = dir - 2;
        }else{
            nextDir = dir + 2;
        }
        Point nextPoint = moves[nextDir];
        int nextRow = nextPoint.row + row;
        int nextCol = nextPoint.col + col;
        if(grid[nextRow][nextCol] != 1) {
            dfs(nextRow,nextCol,dir,grid);
        }

    }
    static class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
