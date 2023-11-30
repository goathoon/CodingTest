package DFS_BFS;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Stack;
public class boj_1987 {
    static int answer = 0;
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] grid = new char[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int r = 0; r < row; r ++){
            grid[r] = br.readLine().toCharArray();
        }
        Set<Character> visitSet = new LinkedHashSet<>();
        dfs(grid,visited, visitSet,0,0);

        System.out.println(answer);
    }
    static void dfs(char[][] grid, boolean[][] visited, Set<Character> visitSet,int row, int col){
        visited[row][col] = true;
        visitSet.add(grid[row][col]);
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,-1,0,1};
        int blockCnt = 0;
        for (int i = 0; i < 4; i++){
            int nextRow = row + drow[i];
            int nextCol = col + dcol[i];
            if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length){
                blockCnt ++;
                if (blockCnt == 4){
                    answer = Math.max(answer,visitSet.size());
                }
                continue;
            }
            char nextChar = grid[nextRow][nextCol];

            if (visitSet.contains(nextChar) || visited[nextRow][nextCol] == true){
                blockCnt ++;
                if (blockCnt == 4){
                    answer = Math.max(answer,visitSet.size());
                }
                continue;
            }
            dfs(grid,visited,visitSet,nextRow,nextCol);
            visited[nextRow][nextCol] = false;
            visitSet.remove(nextChar);
        }
    }
}
