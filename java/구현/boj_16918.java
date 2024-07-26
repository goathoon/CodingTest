package 구현;
import java.io.*;
import java.util.*;
public class boj_16918 {
    static class BombPos {
        int row;
        int col;
        BombPos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());

        char[][] grid = new char[row][col];
        int[][] secGrid = new int[row][col];

        for(int r = 0; r < row; r++){
            grid[r] = br.readLine().toCharArray();
            for(int c = 0; c < col; c++){
                if(grid[r][c] == '.'){
                    secGrid[r][c] = -1;
                }
            }
        }

        Queue<BombPos> q = new LinkedList<>();

        for(int s = 1; s <= sec; s++) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (grid[r][c] == 'O') {
                        secGrid[r][c]++;
                    }
                }
            }

            if (s == 1) continue;

            if (s % 2 == 0) {
                for (int r = 0; r < row; r++) {
                    for (int c = 0; c < col; c++) {
                        if (grid[r][c] == '.') {
                            grid[r][c] = 'O';
                            secGrid[r][c] = 0;
                        }
                    }
                }
            }

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (secGrid[r][c] == 3) {
                        q.add(new BombPos(r, c));
                    }
                }
            }
            while (!q.isEmpty()) {
                BombPos p = q.poll();
                bomb(p.row, p.col, grid, secGrid);
            }
        }

        for(int r = 0; r < row; r++){
            System.out.println(grid[r]);
        }

    }

    private static void bomb(int row, int col, char[][] grid, int[][] secGrid){
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,1,0,-1};

        grid[row][col] = '.';
        secGrid[row][col] = -1;

        for(int i = 0; i < 4; i++){
            int nextRow = row + drow[i];
            int nextCol = col + dcol[i];
            if(nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) continue;

            grid[nextRow][nextCol] = '.';
            secGrid[nextRow][nextCol] = -1;
        }
    }
}
