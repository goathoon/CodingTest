package DFS_BFS;
import java.util.*;
public class pg_리코챗로봇 {


    class Solution {
        static boolean[][] visited;
        static char[][] grid;
        public int solution(String[] board) {
            int startR = 0;
            int startC = 0;
            int goalR = 0;
            int goalC = 0;
            grid = new char[board.length][board[0].length()];
            visited = new boolean[grid.length][grid[0].length];
            for(int r = 0; r < board.length; r ++){
                grid[r] = board[r].toCharArray();
            }
            for(int r = 0; r < grid.length; r ++){
                for (int c = 0; c < grid[0].length; c ++){
                    if(grid[r][c] == 'R'){
                        startR = r;
                        startC = c;
                    }
                    else if (grid[r][c] == 'G'){
                        goalR = r;
                        goalC = c;
                    }

                }
            }
            Queue<PosAndPrice> q = new LinkedList<>();
            q.add(new PosAndPrice(startR,startC,0));
            visited[startR][startC] = true;

            while(!q.isEmpty()){
                PosAndPrice curPos = q.poll();
                int curR = curPos.row;
                int curC = curPos.col;
                int curP = curPos.price;

                if(curR == goalR && curC == goalC){
                    return curP;
                }

                int nextR = curR;
                int nextC = curC;
                //위로
                while(nextR -1 >= 0 && grid[nextR -1][curC] != 'D'){
                    nextR -= 1;
                }
                if (!visited[nextR][nextC]){
                    visited[nextR][nextC] = true;
                    q.add(new PosAndPrice(nextR,nextC,curP + 1));
                }

                nextR = curR;
                nextC = curC;
                //아래로
                while(nextR + 1 <= grid.length - 1 && grid[nextR + 1][curC] != 'D'){
                    nextR += 1;
                }
                if (!visited[nextR][nextC]){
                    visited[nextR][nextC] = true;
                    q.add(new PosAndPrice(nextR,nextC,curP + 1));
                }

                nextR = curR;
                nextC = curC;
                // 왼쪽
                while(nextC - 1 >= 0 && grid[nextR][nextC - 1] != 'D'){
                    nextC -=1;
                }
                if (!visited[nextR][nextC]){
                    visited[nextR][nextC] = true;
                    q.add(new PosAndPrice(nextR,nextC,curP + 1));
                }
                nextR = curR;
                nextC = curC;

                // 오른쪽
                while(nextC + 1 <= grid[0].length - 1 && grid[nextR][nextC+1] != 'D'){
                    nextC +=1;
                }
                if (!visited[nextR][nextC]){
                    visited[nextR][nextC] = true;
                    q.add(new PosAndPrice(nextR,nextC,curP + 1));
                }
                nextR = curR;
                nextC = curC;
            }
            return -1;

        }
        static class PosAndPrice{
            int row;
            int col;
            int price;
            PosAndPrice(int row, int col, int price){
                this.row = row;
                this.col = col;
                this.price = price;
            }
        }
    }
}
