package DP;
import java.io.*;
import java.util.*;
public class boj_4485 {
    static class Pos {
        int row;
        int col;
        int cost;
        Pos(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    static int[] drow = {1,0,-1,0};
    static int[] dcol = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int turn = 0;
        while(true){
            turn ++;
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                return;
            }

            int[][] dp = new int[N][N];
            initDP(dp);
            int[][] grid = new int[N][N];
            for(int r = 0; r < N; r++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int c = 0; c < N; c++){
                    grid[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<Pos> q = new LinkedList<>();
            q.add(new Pos(0,0,grid[0][0]));
            dp[0][0] = grid[0][0];
            while(!q.isEmpty()){
                Pos curP = q.poll();
                int curR = curP.row;
                int curC = curP.col;
                int curCost = curP.cost;
                if(curCost > dp[curR][curC]) continue;

                for(int i = 0; i < 4; i++){
                    int nextR = curR + drow[i];
                    int nextC = curC + dcol[i];
                    if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N){
                        continue;
                    }
                    if(dp[nextR][nextC] > curCost + grid[nextR][nextC]){
                        dp[nextR][nextC] = curCost + grid[nextR][nextC];
                        q.add(new Pos(nextR,nextC,dp[nextR][nextC]));
                    }
                }
            }
            System.out.println("Problem " + turn + ": " + dp[N-1][N-1]);

        }
    }
    public static void initDP(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}
