package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17144 {
    static int[][] grid;
    static int[][] spreadGrid;
    static int upRow = 0;
    static int downRow = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());

        grid = new int[row][col];
        spreadGrid = new int[row][col];
        upRow = 0;
        downRow = 0;
        for(int r = 0; r < row; r++){
            st = new StringTokenizer(br.readLine(), " ");
            grid[r][0] = Integer.parseInt(st.nextToken());
            if(grid[r][0] == -1){
                if (upRow == 0){
                    upRow = r;
                }
                else{
                    downRow = r;
                }
            }
            for(int c = 1; c < col; c++){
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        while(sec != 0){
            spread();
            applySpread();
            upCleaning();
            downCleaning();
            sec--;
        }
        System.out.println(sumGrid());
    }

    private static int sumGrid() {
        int answer = 0;
        for(int r = 0; r < grid.length; r ++){
            for(int c = 0; c<grid[0].length; c++){
                answer += grid[r][c];
            }
        }
        return answer + 2;
    }

    static void spread(){
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int r = 0; r < grid.length; r ++){
            for(int c = 0; c < grid[0].length; c ++){
                if(grid[r][c] != 0){
                    int spreadCnt = 4;
                    for(int i = 0; i<4; i++){
                        int nextRow = r + drow[i];
                        int nextCol = c + dcol[i];
                        if(0 > nextRow || nextRow >= grid.length || 0 > nextCol || nextCol >= grid[0].length || grid[nextRow][nextCol] == -1){
                            spreadCnt --;
                            continue;
                        }
                        spreadGrid[nextRow][nextCol] += grid[r][c] / 5;
                    }
                    grid[r][c] -= (grid[r][c] / 5) * spreadCnt;
                }
            }
        }
    }
    static void applySpread(){
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                grid[r][c] += spreadGrid[r][c];
                spreadGrid[r][c] = 0;
            }
        }
    }
    static void upCleaning(){
        // 시계반대방향으로 돌때 청정기에 도착하는 부분
        grid[upRow-1][0] = 0;
        for(int r = upRow-2; r>=0; r--){
            grid[r+1][0] = grid[r][0];
        }
        // 그 다음
        for(int c= 1; c <= grid[0].length -1; c ++){
            grid[0][c-1] = grid[0][c];
        }
        // 그 다음
        for(int r = 1; r <= upRow; r++){
            grid[r-1][grid[0].length-1] = grid[r][grid[0].length-1];
        }
        // 그 다음
        for(int c = grid[0].length - 2; c >= 1; c--){
            grid[upRow][c+1] = grid[upRow][c];
        }
        grid[upRow][1] = 0;
    }
    static void downCleaning(){
        grid[downRow+1][0] = 0;
        for(int r = downRow+2; r<=grid.length-1; r++){
            grid[r-1][0] = grid[r][0];
        }
        // 그 다음
        for(int c= 1; c <= grid[0].length -1; c ++){
            grid[grid.length-1][c-1] = grid[grid.length-1][c];
        }
        // 그 다음
        for(int r = grid.length-2; r >= downRow; r--){
            grid[r+1][grid[0].length-1] = grid[r][grid[0].length-1];
        }
        // 그 다음
        for(int c = grid[0].length - 2; c >= 1; c--){
            grid[downRow][c+1] = grid[downRow][c];
        }
        grid[downRow][1] = 0;
    }
}
