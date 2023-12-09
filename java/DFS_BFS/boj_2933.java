package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2933 {
    static boolean[][] visited;
    static char[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        grid = new char[row][col];
        visited = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            grid[r] = br.readLine().toCharArray();
        }

        int cnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<cnt; i++){
            int mineralCol = -1;
            int floor = row - Integer.parseInt(st.nextToken());
            if (i%2==0){
                for (int c = 0; c < col; c++){
                    if (grid[floor][c] == 'x'){
                        mineralCol = c;
                        break;
                    }
                }
            }
            else{
                for (int c= col-1; c >= 0; c--){
                    if(grid[floor][c] == 'x'){
                        mineralCol = c;
                        break;
                    }
                }
            }
            if (mineralCol == -1){
                continue;
            }
            grid[floor][mineralCol] = '.';
            for(int c = 0; c < col; c++){
                bfs(row-1,c);
            }
            int[] drow = {1,0,-1,0};
            int[] dcol = {0,-1,0,1};
            boolean flag = false;
            for(int k = 0; k<4; k++){
                if (flag) break;

                int nextRow = floor+drow[k];
                int nextCol = mineralCol + dcol[k];
                if (nextRow < 0 || nextRow >= row || nextCol< 0 || nextCol >= col
                    || grid[nextRow][nextCol] == '.' || visited[nextRow][nextCol]){
                    continue;
                }
                int minHeight = getMinHeight();
                dropCluster(grid,minHeight);
                flag = true;
            }

            for (int r = 0; r < row; r++){
                for(int c = 0; c<col; c++){
                    visited[r][c] = false;
                }
            }
        }
        for (int r = 0; r < grid.length; r++){
            System.out.println(String.valueOf(grid[r]));
        }

    }

    static int getMinHeight() {
        int minHeight = 101;
        for(int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if (grid[r][c] == 'x' && !visited[r][c]){
                    for (int h = r+1; h < grid.length; h++){
                        if (grid[h][c] =='x' && visited[h][c] ){
                            minHeight = Math.min(minHeight, h-r-1);
                            break;
                        }
                        minHeight = Math.min(minHeight, grid.length - r - 1);
                    }
                }
            }
        }
        return minHeight;
    }

    static void dropCluster(char[][] grid, int height){
        for (int c = 0; c < grid[0].length; c++){
            for(int r = grid.length-1; r>=0 ; r--){
                if(grid[r][c] == 'x' && !visited[r][c]){
                    grid[r+height][c] = grid[r][c];
                    grid[r][c] = '.';
                }
            }
        }
    }
    static void bfs(int row, int col){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(row,col));
        while (!q.isEmpty()){
            Pos curPos = q.poll();
            int curRow = curPos.row;
            int curCol = curPos.col;
            int[] drow = {1,0,-1,0};
            int[] dcol = {0,-1,0,1};
            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + drow[i];
                int nextCol = curCol + dcol[i];
                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length
                        || grid[nextRow][nextCol] == '.' || visited[nextRow][nextCol]) {
                    continue;
                }
                q.offer(new Pos(nextRow,nextCol));
                visited[nextRow][nextCol] = true;
            }

        }

    }
    static class Pos{
        int row;
        int col;
        Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
