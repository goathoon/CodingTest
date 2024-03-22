package DFS_BFS;
import java.util.*;
public class pg_경주로건설 {

    class Solution {
        public int solution(int[][] board) {
            class Pos{
                int row;
                int col;
                int dir;
                int cost;
                Pos(int row, int col, int dir, int cost){
                    this.row = row;
                    this.col = col;
                    this.dir = dir;
                    this.cost = cost;
                }
            }
            int[] drow = {0,1,0,-1};
            int[] dcol = {1,0,-1,0};
            int[][][] visit = new int[board.length][board.length][4];
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board.length; j++){
                    for(int k = 0; k < 4; k++){
                        visit[i][j][k] = Integer.MAX_VALUE;
                    }
                }
            }
            Queue<Pos> q = new LinkedList<>();
            q.add(new Pos(0,0,-1,0));
            int ans = Integer.MAX_VALUE;
            while(!q.isEmpty()){
                Pos cur = q.poll();
                int curRow = cur.row;
                int curCol = cur.col;
                int curDist = cur.dir;
                int curCost = cur.cost;
                if(curRow == board.length-1 && curCol == board.length-1){
                    ans = Math.min(curCost, ans);
                }
                if(curDist == -1){
                    for(int i = 0; i < 4; i++){
                        visit[0][0][i] = 0;
                    }
                }
                else{
                    if(visit[curRow][curCol][curDist] < curCost) continue;
                }

                for(int d = 0; d < 4; d++){
                    int nextRow = curRow + drow[d];
                    int nextCol = curCol + dcol[d];
                    if(nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board.length || board[nextRow][nextCol] == 1) continue;
                    if(curDist == -1 || d == curDist){
                        if(visit[nextRow][nextCol][d] > curCost + 100){
                            visit[nextRow][nextCol][d] = curCost+100;
                            q.add(new Pos(nextRow,nextCol,d,curCost+100));
                        }
                    }else{
                        if(visit[nextRow][nextCol][d] > curCost + 600){
                            visit[nextRow][nextCol][d] = curCost + 600;
                            q.add(new Pos(nextRow,nextCol,d,curCost+600));
                        }
                    }
                }

            }
            return ans;
        }
    }
}
