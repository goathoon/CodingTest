package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17070 {
    static int[][] grid;
    static int N;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,1, 1);
        /**
         * dir = 0 : 세로
         * dir = 1 : 가로
         * dir = 2 : 대각선
         */
        System.out.println(answer);

    }
    static void dfs(int row, int col, int dir){
        if (row == N-1 && col == N-1){
            answer += 1;
            return;
        }
        switch(dir){
            case 0 :{
                if (row+1 <= N-1 && grid[row+1][col] == 0){
                    dfs(row+1,col,dir);
                }
                if (row+1 <= N-1 && col+1 <= N-1 && grid[row+1][col] == 0 && grid[row+1][col+1] == 0 && grid[row][col+1] == 0){
                    dfs(row+1,col+1,2);
                }
                break;
            }
            case 1 :{
                if(col+1 <= N-1 && grid[row][col+1] == 0){
                    dfs(row,col+1,dir);
                }
                if(col+1 <= N-1 && row+1 <= N-1 && grid[row+1][col] == 0 && grid[row+1][col+1] == 0 && grid[row][col+1] == 0){
                    dfs(row+1,col+1,2);
                }
                break;
            }
            case 2 :{
                if(col+1 <= N-1 && grid[row][col+1] == 0){
                    dfs(row,col+1,1);
                }
                if(row+1 <= N-1 && grid[row+1][col] == 0){
                    dfs(row+1,col,0);
                }
                if(col+1 <= N-1 && row+1 <= N-1 && grid[row+1][col] == 0 && grid[row+1][col+1] == 0 && grid[row][col+1] == 0){
                    dfs(row+1,col+1,2);
                }
                break;
            }
        }
    }
}
