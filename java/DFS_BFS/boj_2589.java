package DFS_BFS;

import java.io.*;
import java.util.*;
public class boj_2589 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] grid = new char[R][C];
        boolean[][] visit = new boolean[R][C];
        for(int r = 0; r < R; r++){
            grid[r] = br.readLine().toCharArray();
        }
        int[][] cost = new int[R][C];
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(grid[r][c] == 'L'){
                    bfs(r,c,grid,cost,visit);
                    initVisit(visit);
                }
            }
        }
        int ans = 0;
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                ans = Math.max(cost[r][c],ans);
            }
        }
        System.out.println(ans);
    }
    public static void bfs(int row, int col, char[][]grid, int[][] cost, boolean[][] visit){
        class Pos{
            int row;
            int col;
            int cost;
            Pos(int row, int col, int cost){
                this.row = row;
                this.col = col;
                this.cost = cost;
            }
        }
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(row,col,0));
        visit[row][col] = true;
        int[]drow = {1,0,-1,0};
        int[]dcol = {0,-1,0,1};

        while(!q.isEmpty()){
            Pos curP = q.poll();
            int curR = curP.row;
            int curC = curP.col;
            cost[curR][curC] = Math.max(cost[curR][curC], curP.cost);
            for(int i = 0 ; i < 4; i++){
                int nextR = curR + drow[i];
                int nextC = curC + dcol[i];
                if(nextR < 0 || nextR >= grid.length || nextC < 0 || nextC >= grid[0].length || grid[nextR][nextC] == 'W'|| visit[nextR][nextC]) continue;

                q.add(new Pos(nextR,nextC, curP.cost+1));
                visit[nextR][nextC] = true;
            }
        }
    }
    public static void initVisit(boolean[][] visit){
        for(int r = 0; r < visit.length; r++){
            for(int c = 0; c < visit[0].length; c++){
                visit[r][c] = false;
            }
        }
    }
}
