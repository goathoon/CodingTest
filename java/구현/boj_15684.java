package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15684 {
    static class Pos{
        int row;
        int col;
        Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int MAKE = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] grid = new int[R+1][C+1];
        boolean[][] visit = new boolean[R+1][C+1];
        int x = 1;
        for(int m = 0; m < MAKE; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            grid[r][c] = x;
            grid[r][c+1] = x;
            x++;
        }

        boolean isEnd = true;
        for(int c = 1; c <= C; c++){
            if(!move(grid,c)){
                isEnd = false;
                break;
            }
        }
        if(isEnd) {
            System.out.println(0);
            System.exit(0);
        }

        for(int i = 1; i <= 3; i++){
            isEnd= false;
            if(dfs(grid, i,visit,x+1)){
                isEnd = true;
                System.out.println(i);
                break;
            }
        }

        if(!isEnd){
            System.out.println(-1);
        }

    }
    public static boolean move(int[][] grid, int c){
        int r = 1;
        int init_c = c;
        while(r != grid.length){
            if(grid[r][c] != 0){
                if(c == grid[0].length-1){
                    if(grid[r][c-1] == grid[r][c]){
                        c = c-1;
                    }
                }
                else if(c == 1){
                    if(grid[r][c+1] == grid[r][c]){
                        c = c+1;
                    }
                }
                else{
                    if(grid[r][c+1] == grid[r][c]){
                        c = c+1;
                    }
                    else if(grid[r][c-1] == grid[r][c]){
                        c = c-1;
                    }
                }
            }
            r++;
        }
        if (c == init_c) return true;
        return false;
    }
    public static boolean dfs(int[][] grid, int i, boolean[][] visit,int x){
        if(i==0){
            for(int l = 1; l <= grid[0].length-1; l++){
                if(!move(grid,l)){
                    return false;
                }
            }
            return true;
        }

        for(int r = 1; r < grid.length; r++){
            for(int c = 1; c < grid[0].length-1; c++){
                boolean isEnd = false;
                if(grid[r][c] != 0 || grid[r][c+1] != 0 || visit[r][c]) continue;

                grid[r][c] = x;
                grid[r][c+1] = x;
                visit[r][c] = true;
                isEnd = dfs(grid,i-1,visit,x+1);
                if(isEnd){
                    return true;
                }
                grid[r][c] = 0;
                grid[r][c+1] = 0;
                visit[r][c] = false;
            }
        }
        return false;
    }

}
