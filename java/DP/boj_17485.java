package DP;
import java.io.*;
import java.util.*;
public class boj_17485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
        int[][] grid = new int[row][col];
        int[][][] dp = new int[row+1][col][3];

        for(int r = 0; r < dp.length; r++){
            for(int c = 0; c < dp[0].length; c++){
                for(int d = 0; d < 3; d++){
                    dp[r][c][d] = Integer.MAX_VALUE;
                }
            }
        }

        for(int r = 0; r < row; r++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < col; c++){
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dcol = {-1,0,1};

        for(int r = 1; r <= row; r++){
            for(int c = 0; c < col; c++){
                if(r == 1) {
                    // 초기 dp배열의 dir은 0으로 설정 (방향이 의미 없음)
                    dp[r][c][0] = grid[r-1][c];
                }
                else if(r == 2) {
                    for(int dir = 0; dir < 3; dir++) {
                        int diffCol = dcol[dir];
                        // Out Of Bound
                        if(c + diffCol < 0 || c + diffCol >= col) continue;

                        // r == 2인경우 이전 row에서 dir = 0 만 체크하면 된다.
                        // 그 이후부터는 방향이 중요해짐
                        dp[r][c][dir] = Math.min(dp[r][c][dir], dp[r-1][c+diffCol][0] + grid[r-1][c]);
                    }
                }
                else{
                    for(int dir = 0; dir < 3; dir++) {
                        int diffCol = dcol[dir];

                        if(c + diffCol < 0 || c + diffCol >= col) continue;

                        for(int beforeDir = 0; beforeDir < 3; beforeDir++){
                            if(dir == beforeDir || dp[r-1][c+diffCol][beforeDir] == Integer.MAX_VALUE) continue;
                            dp[r][c][dir] = Math.min(dp[r][c][dir], dp[r-1][c+diffCol][beforeDir] + grid[r-1][c]);
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int c = 0; c < col; c++){
            for(int dir = 0; dir < 3; dir++){
                ans = Math.min(ans,dp[row][c][dir]);
            }
        }
        System.out.println(ans);
    }
}
