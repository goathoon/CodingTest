package DP;

/**
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
 *
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * Output: 6
 * Example 2:
 *
 *
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output: 12
 */
public class leet_576 {
    class Solution {
        // Top - Down 방식이다.
        // 맨 처음 부터 시작해서 언제가 base case가 되는지 확인하고, 위에서부터 작은 문제를 풀때까지 내려가고,
        // 작은문제를 풀면 다시 위로 가는 방식이다.

        // (startRow, startCol) 에서 부터 가지치기 하며 내려가는 발상에서 생각하기 쉬울 것 같다.
        static int [][][] dp;
        static boolean[][][] visit;
        final int MOD = 1000000007;
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            visit = new boolean[m][n][maxMove+1];
            dp = new int [m][n][maxMove+1];
            return dfs(m,n,startRow,startColumn,maxMove) % MOD;
        }
        public int dfs(int m, int n, int row, int col, int move){
            if(row < 0 || row == m || col < 0 || col == n) return 1;
            if (move == 0) return 0;
            if(visit[row][col][move]){
                return dp[row][col][move];
            }
            visit[row][col][move] = true;
            dp[row][col][move] = ((dfs(m,n,row-1,col,move-1) + dfs(m,n,row+1,col,move-1)) % MOD + (dfs(m,n,row,col+1,move-1) + dfs(m,n,row,col-1,move-1)) % MOD) % MOD;
            return dp[row][col][move] % MOD;
        }
    }
    //BOTTOM- UP 방식 훨씬 생각하기 어려웠다.
    class Solution2 {
        static int [][][] dp;
        final int MOD = 1000000007;
        // move를 0번했을 때부터 차차 올라가면서 체크
        // dp [남은 move수][row][col] 로써, 그 값은 해당 row,col에서 다음 남은 move수 만큼 이동했을 때, out of 할 경우의 수
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            dp = new int[maxMove+1][m][n];
            for(int j = 1; j <= maxMove; j++){
                // m의 이동 거리가 남은 경우, m-1의 이동거리가 남은 경우의 방법수를 더하는 식으로 dp를 활용
                // 잘 생각해보면 m의 이동거리가 남았다는 사실은 다음 이동 위치에는 m-1의 이동거리가 남았다는 것이기 때문이다.
                for(int r = 0; r < m; r++){
                    for(int c = 0; c < n; c++){
                        if(r-1 < 0) dp[j][r][c] = (dp[j][r][c] + 1) % MOD; //해당 위치가 m번남았을 때, out된 경우이므로 그냥 1을 더함
                        else dp[j][r][c] = (dp[j-1][r-1][c] + dp[j][r][c]) % MOD;
                        if(r+1 ==m) dp[j][r][c] = (dp[j][r][c] + 1) % MOD;
                        else dp[j][r][c] = (dp[j-1][r+1][c] + dp[j][r][c]) % MOD;
                        if(c-1 < 0) dp[j][r][c] = (dp[j][r][c] + 1) % MOD;
                        else dp[j][r][c] = (dp[j-1][r][c-1] + dp[j][r][c]) % MOD;
                        if(c+1 ==n) dp[j][r][c] = (dp[j][r][c] + 1) % MOD;
                        else dp[j][r][c] = (dp[j-1][r][c+1] + dp[j][r][c]) % MOD;
                    }
                }
            }
            return dp[maxMove][startRow][startColumn] % MOD;
        }
    }
    //BOTTOM- UP 방식
    //이전 BOTTOM_UP보다 내가 직접 이해하기 쉬운 방법의 점화식이었다.
    class Solution3 {
        static int [][][] dp;
        final int MOD = 1000000007;
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            // (m,n)에 move만큼 이동한 후에 도달하는 경우의 수를 dp배열로 선언하였다.
            // move만큼 이동했을 때, 도달하는 경우의 수를 각 (row,col)마다 구한다.
            // 그 후에, out of bound된 위치의 dp배열을 move=0 부터 move=maxMove 경로의 수를 다 더한다.
            dp = new int[maxMove+1][m+2][n+2];
            int answer = 0;
            int trickRow = startRow + 1;
            int trickCol = startColumn + 1;
            dp[0][trickRow][trickCol] = 1;
            int[] drow = {1,0,-1,0};
            int[] dcol = {0,1,0,-1};
            for(int move = 1; move <= maxMove; move++){
                for(int r = 0; r <= m+1; r++){
                    for(int c = 0; c <= n+1; c++){
                        for(int i = 0; i < 4; i++){
                            int beforeRow = drow[i] + r;
                            int beforeCol = dcol[i] + c;
                            if(beforeRow >= m+1 || beforeRow <= 0 || beforeCol >= n+1 || beforeCol <= 0){
                                continue;
                            }
                            dp[move][r][c] = dp[move][r][c] % MOD + dp[move-1][beforeRow][beforeCol] % MOD;
                        }
                    }
                }
            }
            for(int move = 0; move <= maxMove; move++){
                for(int r = 0; r <= m+1; r++){
                    answer = answer % MOD + dp[move][r][0] % MOD;
                    answer = answer % MOD + dp[move][r][n+1] % MOD;
                }
                for(int c = 0; c <= n+1; c++){
                    answer = answer % MOD + dp[move][0][c] % MOD;
                    answer = answer % MOD + dp[move][m+1][c] % MOD;
                }
            }
            return answer % MOD;
        }
    }
}
