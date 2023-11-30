package DFS_BFS;

import java.io.*;
import java.util.StringTokenizer;

class boj_21736 {
    static boolean [][] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] grid = new char[row][col];
        visited = new boolean[row][col];
        Pos startPos = null;
        for(int r = 0; r < row; r++){
            grid[r] = br.readLine().toCharArray();
            for(int idx = 0; idx < col; idx ++){
                if (grid[r][idx] == 'I'){
                    startPos = new Pos(r,idx);
                }
            }
        }
        dfs(grid,startPos.row,startPos.col);

        if(answer ==0){
            System.out.println("TT");
        }
        else{
            System.out.println(answer);
        }
    }

    static void dfs(char[][] grid, int row, int col){
        if(grid[row][col] == 'P') answer += 1;

        visited[row][col] = true;
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,-1,0,1};
        for(int i = 0; i < 4; i++){
            int nextRow = drow[i] + row;
            int nextCol = dcol[i] + col;
            if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length
                    || visited[nextRow][nextCol] == true
                    || grid[nextRow][nextCol] == 'X'){
                continue;
            }
            dfs(grid, nextRow,nextCol);
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
