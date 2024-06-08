package 구현;
import java.io.*;
import java.util.*;
public class boj_16724 {
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
        char[][] grid = new char[row][col];
        int[][] visit = new int[row][col];
        for(int r = 0; r < row; r++){
            String s = br.readLine();
            for(int c = 0; c < s.length(); c++){
                grid[r][c] = s.charAt(c);
            }
        }
        int val = 1;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(visit[r][c] == 0){
                    dfs(val,r,c,grid,visit);
                    if(val == visit[r][c]){
                        ans++;
                    }
                    val++;
                }
            }
        }

        System.out.println(ans);
    }
    public static int dfs(int val, int row, int col, char[][] grid, int[][] visit){
        if(visit[row][col] != 0){
            return visit[row][col];
        }
        visit[row][col] = val;
        int next = -1;
        switch(grid[row][col]){
            case 'D':{
                next = dfs(val,row+1,col,grid,visit);
                break;
            }
            case 'U':{
                next = dfs(val,row-1,col,grid,visit);
                break;
            }
            case 'L':{
                next = dfs(val,row,col-1,grid,visit);
                break;
            }
            case 'R':{
                next = dfs(val,row,col+1,grid,visit);
                break;
            }
        }
        return visit[row][col] = next;
    }
}
