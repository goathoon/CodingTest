package DFS_BFS;
import java.io.*;
import java.util.*;

public class boj_17265_2 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] grid = new char[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < N; c++){
                grid[i][c] = st.nextToken().charAt(0);
            }
        }
        dfs(0,0,grid[0][0]-'0', grid);
        System.out.println(max + " " + min);
    }
    public static void dfs(int row, int col, int val, char[][] grid){
        if(row == grid.length-1 && col == grid[0].length-1) {
            max = Math.max(val, max);
            min = Math.min(val, min);
        }
        if(col + 2 < grid[0].length){
            dfs(row,col+2,cal(val,grid[row][col+1],grid[row][col+2]-'0'),grid);
        }
        if(row + 1 < grid.length && col + 1 < grid[0].length){
            dfs(row+1,col+1,cal(val,grid[row][col+1],grid[row+1][col+1]-'0'),grid);
            dfs(row+1,col+1,cal(val,grid[row+1][col],grid[row+1][col+1]-'0'),grid);
        }
        if(row + 2 < grid.length){
            dfs(row+2,col,cal(val,grid[row+1][col],grid[row+2][col]-'0'),grid);
        }
    }
    public static int cal(int num, char op, int next){
        switch(op){
            case '*' : {
                return num * next;
            }
            case '+' : {
                return num + next;
            }
            case '-': {
                return num - next;
            }
        }
        return -1;
    }
}
