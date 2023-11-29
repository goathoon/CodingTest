package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.StringTokenizer;

public class boj_14940 {
    static class Pos{
        int row;
        int col;
        int dist;
        Pos(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    static int[][] grid;
    static int[][] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        grid = new int[row+1][col+1];
        visit = new int[row+1][col+1];
        initVisit();

        Pos startPos = null;
        for(int r = 1; r < row + 1; r++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 1; c < col + 1; c++){
                grid[r][c] = Integer.parseInt(st.nextToken());
                if (grid[r][c] == 0) visit[r][c] = 0;
                else if (grid[r][c] == 2){
                    startPos = new Pos(r,c,0);
                    visit[r][c] = 0;
                }
            }
        }

        Queue<Pos> q = new LinkedList<>();
        q.add(startPos);
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,-1,0,1};

        while(!q.isEmpty()){
            Pos curPos = q.poll();
            int curRow = curPos.row;
            int curCol = curPos.col;
            int curDist = curPos.dist;
            for (int i = 0 ; i <4 ; i ++){
                int nextRow = curRow + drow[i];
                int nextCol = curCol + dcol[i];
                int nextDist = curDist + 1;
                if (nextRow == 0 || nextRow > row || nextCol == 0 || nextCol > col
                        || visit[nextRow][nextCol] != -1) continue;

                visit[nextRow][nextCol] = nextDist;
                q.add(new Pos(nextRow,nextCol,nextDist));
            }
        }
        for (int r = 1; r < row+1; r++){
            for (int c = 1; c<col+1; c++){
                System.out.print(visit[r][c] + " ");
            }
            System.out.println();
        }
    }

    static void initVisit(){
        for (int r = 1; r < visit.length; r ++){
            for ( int c = 1; c< visit[0].length ; c ++){
                visit[r][c] = -1;
            }
        }
    }
}
