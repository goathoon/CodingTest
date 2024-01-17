package DFS_BFS;
import java.util.*;
public class pg_등굣길 {
    class Solution {
        // m = column
        // n = row
        public int solution(int m, int n, int[][] puddles) {
            int[][][] memo = new int[n+1][m+1][2];
            boolean[][][] visited = new boolean[n+1][m+1][2];

            // 물 웅덩이는 그냥 visit 처리
            for(int[] p : puddles){
                if(p.length >= 2){
                    for(int i = 0 ; i<2; i++){
                        visited[p[1]][p[0]][i] = true;
                    }
                }
            }

            Queue<PosPrice> q = new LinkedList<>();
            q.add(new PosPrice(1,1));
            for(int i = 0; i <2; i++){
                visited[1][1][i] = true;
                memo[1][1][i] = 1;
            }
            int[] dr = {1,0};
            int[] dc = {0,1};
            while(!q.isEmpty()){
                PosPrice curPos = q.poll();
                int curR = curPos.row;
                int curC = curPos.col;

                if(curR == n && curC == m){
                    break;
                }

                for(int i = 0; i < 2; i++){
                    int nextR = curR + dr[i];
                    int nextC = curC + dc[i];
                    if( nextR > n || nextC > m) continue;
                    if(visited[nextR][nextC][i]) continue;
                    if(curR == 1 && curC == 1){
                        memo[nextR][nextC][i] = 1;
                    }
                    else{
                        memo[nextR][nextC][i] = (memo[curR][curC][0] + memo[curR][curC][1]) % 1_000_000_007;
                    }
                    visited[nextR][nextC][i] = true;

                    q.add(new PosPrice(nextR,nextC));
                }
            }
            long answer = 0;
            for(int i = 0; i < 2; i++){
                answer += memo[n][m][i];
            }

            return  (int)(answer % 1_000_000_007L);
        }
    }
    class PosPrice{
        int row;
        int col;
        PosPrice(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
