package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2638 {
    static int [][] grid;
    static boolean [][] air;
    static int[] drow = {0,1,0,-1};
    static int[] dcol = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        grid = new int[row][col];
        air = new boolean[row][col];
        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < col; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int c = 0; c < grid[0].length; c ++){
            if(grid[0][c] == 0 && !air[0][c]){
                dfsOfAir(0,c);
            }
            if(grid[grid.length-1][c] == 0 && !air[grid.length-1][c]){
                dfsOfAir(grid.length-1,c);
            }
        }
        for(int r = 0; r < grid.length; r++){
            if(grid[r][0] == 0 && !air[r][0]){
                dfsOfAir(r,0);
            }
            if(grid[r][grid[0].length-1] == 0 && !air[r][grid[0].length-1]){
                dfsOfAir(r,grid[0].length-1);
            }
        }
        int answer = 0;
        while(true) {
            boolean isEmpty = true;
            boolean isUp = updateGrid();
            if(isUp) answer ++;

            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    if (grid[r][c] == 1) {
                        isEmpty = false;
                        int cnt = 0;
                        for (int i = 0; i < 4; i++) {
                            int checkRow = drow[i] + r;
                            int checkCol = dcol[i] + c;
                            if (0 > checkRow || checkRow >= grid.length || 0 > checkCol || checkCol >= grid[0].length)
                                continue;
                            if (air[checkRow][checkCol]) cnt++;
                        }
                        if (cnt >= 2) {
                            grid[r][c] = 2;
                        }
                    }
                }
            }
            if (isEmpty) break;
        }
        System.out.println(answer);
    }
    static void dfsOfAir(int curRow, int curCol){
        air[curRow][curCol] = true;
        for(int i = 0; i < 4; i++){
            int nextRow = drow[i] + curRow;
            int nextCol = dcol[i] + curCol;
            if( 0 > nextRow || nextRow >= grid.length || 0 > nextCol || nextCol >= grid[0].length || grid[nextRow][nextCol] == 1 || grid[nextRow][nextCol] == 2){
                continue;
            }
            if (air[nextRow][nextCol]){
                continue;
            }
            dfsOfAir(nextRow,nextCol);
        }
    }
    static boolean updateGrid(){
        boolean isUp = false;
        for(int r = 0; r < grid.length; r++){
            for (int c = 0; c<grid[0].length; c++){
                if(grid[r][c] == 2){
                    isUp = true;
                    grid[r][c] = 0;
                    dfsOfAir(r, c);
                }
            }
        }
        return isUp;
    }
}
