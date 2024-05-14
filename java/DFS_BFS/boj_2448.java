package DFS_BFS;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class boj_2448 {
    static char[][] grid;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        grid = new char[N][2*N-1];
        for(int r = 0 ; r < N; r++){
            for(int c = 0; c < 2*N-1; c++){
                grid[r][c] = ' ';
            }
        }

        dfs(0, N-1,N);

        for(int r = 0 ; r < N; r++){
            for(int c = 0; c < 2*N-1; c++){
//                System.out.print(grid[r][c]);
                bw.write(grid[r][c]);
            }
            bw.newLine();
        }
        bw.flush();
    }
    public static void dfs(int row, int col, int n){
        if(n==3){
            grid[row][col] = '*';
            grid[row+1][col-1] = grid[row+1][col+1] = '*';
            grid[row+2][col-2] = grid[row+2][col-1] = grid[row+2][col] = grid[row+2][col+1] = grid[row+2][col+2] = '*';
            return;
        }
        dfs(row,col,n/2);
        dfs(row+n/2,col-n/2,n/2);
        dfs(row+n/2,col+n/2, n/2);
    }
}
