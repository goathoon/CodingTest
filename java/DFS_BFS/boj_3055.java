package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3055 {
    public static void main(String[] args) throws IOException {
        class Pos{
            int row;
            int col;
            int cnt;
            Pos(int row, int col){
                this.row = row;
                this.col = col;
            }
            Pos(int row, int col, int cnt){
                this.row = row;
                this.col= col;
                this.cnt = cnt;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] grid = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        int startR = 0;
        int startC = 0;
        Queue<Pos> waters = new LinkedList<>();
        Queue<Pos> moves = new LinkedList<>();
        for(int r = 0; r < R; r++){
            grid[r] = br.readLine().toCharArray();
            for(int c = 0; c < C; c++){
                if(grid[r][c] == 'S'){
                    startR = r;
                    startC = c;
                }
                else if(grid[r][c] == '*'){
                    waters.add(new Pos(r,c));
                }
            }
        }
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        moves.add(new Pos(startR,startC,0));
        visited[startR][startC] = true;
        while(true) {
            int curWater = waters.size();
            while (curWater > 0) {
                curWater--;
                Pos water = waters.poll();
                int waterR = water.row;
                int waterC = water.col;
                for (int i = 0; i < 4; i++) {
                    int nextR = waterR + drow[i];
                    int nextC = waterC + dcol[i];
                    if (nextR < 0 || nextR >= grid.length || nextC < 0 || nextC >= grid[0].length || grid[nextR][nextC] == 'X' || grid[nextR][nextC] == 'D' || grid[nextR][nextC] == '*') {
                        continue;
                    }
                    grid[nextR][nextC] = '*';
                    waters.add(new Pos(nextR, nextC));
                }
            }
            int moveCnt = moves.size();
            while (moveCnt > 0) {
                moveCnt--;
                Pos curPos = moves.poll();
                int curR = curPos.row;
                int curC = curPos.col;
                if (grid[curR][curC] == 'D') {
                    System.out.println(curPos.cnt);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int nextR = curR + drow[i];
                    int nextC = curC + dcol[i];
                    if (nextR < 0 || nextR >= grid.length || nextC < 0 || nextC >= grid[0].length || grid[nextR][nextC] == 'X' || visited[nextR][nextC] || grid[nextR][nextC] == '*') {
                        continue;
                    }
                    visited[nextR][nextC] = true;
                    moves.add(new Pos(nextR, nextC, curPos.cnt + 1));
                }
            }
            if (moves.size() == 0) {
                System.out.println("KAKTUS");
                return;
            }
        }
    }
}
