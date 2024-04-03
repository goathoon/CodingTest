package DFS_BFS;

import java.io.*;
import java.util.*;

public class boj_1600{
    static int[] jumpR = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] jumpC = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] drow = {1, 0, -1, 0};
    static int[] dcol = {0, -1, 0, 1};
    static int[][] grid;
    static boolean[][][] visit;
    public static void main(String[] args) throws IOException {
        class Pos{
            int row;
            int col;
            int jump;
            int cost;
            Pos(int row, int col, int jump, int cost){
                this.row = row;
                this.col = col;
                this.jump = jump;
                this.cost = cost;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        grid = new int[R][C];
        visit = new boolean[R][C][K+1];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < C; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0,0,K,0));
        visit[0][0][K] = true;
        while(!q.isEmpty()){
            Pos curP = q.poll();
            int curRow = curP.row;
            int curCol = curP.col;
            int curJump = curP.jump;
            int curCost = curP.cost;
            if(curRow == grid.length-1 && curCol == grid[0].length-1){
                System.out.println(curCost);
                return;
            }
            if(curJump > 0) {
                for (int i = 0; i < 8; i++) {
                    int nextRow = curRow + jumpR[i];
                    int nextCol = curCol + jumpC[i];
                    if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length || visit[nextRow][nextCol][curJump-1] || grid[nextRow][nextCol] == 1) continue;

                    q.add(new Pos(nextRow,nextCol, curJump-1, curCost+1));
                    visit[nextRow][nextCol][curJump-1] = true;
                }
            }
            for(int i = 0; i < 4; i++) {
                int nextRow = curRow + drow[i];
                int nextCol = curCol + dcol[i];
                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length || visit[nextRow][nextCol][curJump] || grid[nextRow][nextCol] == 1) continue;

                q.add(new Pos(nextRow,nextCol,curJump,curCost+1));
                visit[nextRow][nextCol][curJump] = true;
            }
        }
        System.out.println(-1);
    }
}
//public class boj_1600 {
//    static int[] jumpR = {-2, -1, 1, 2, 2, 1, -1, -2};
//    static int[] jumpC = {1, 2, 2, 1, -1, -2, -2, -1};
//    static int[] drow = {1, 0, -1, 0};
//    static int[] dcol = {0, -1, 0, 1};
//    static int[][] grid;
//    static int[][][] dp;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int K = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int C = Integer.parseInt(st.nextToken());
//        int R = Integer.parseInt(st.nextToken());
//        grid = new int[R][C];
//        dp = new int[R][C][K+1];
//        for(int r = 0; r < R; r++){
//            st = new StringTokenizer(br.readLine(), " ");
//            for(int c = 0; c < C; c++){
//                grid[r][c] = Integer.parseInt(st.nextToken());
//            }
//        }
//        dfs(0,0,K,0);
//        int ans = Integer.MAX_VALUE;
//        for(int k = 0; k <= K; k++){
//            if(dp[R-1][C-1][k] != 0){
//                ans = Math.min(ans,dp[R-1][C-1][k]);
//            }
//        }
//        if(ans == Integer.MAX_VALUE) System.out.println(-1);
//        else System.out.println(ans);
//    }
//    public static void dfs(int r, int c, int k, int move){
//        // 이미 해당 위치까지의 동작 횟수가 최소값인 경우
//        if(dp[r][c][k] != 0 && move >= dp[r][c][k]) return;
//        dp[r][c][k] =  move;
//        if(r == grid.length-1 && c == grid[0].length-1) return;
//
//        if(k > 0) {
//            for (int i = 0; i < 8; i++) {
//                int nextRow = r + jumpR[i];
//                int nextCol = c + jumpC[i];
//                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length || grid[nextRow][nextCol] == 1) continue;
//
//                dfs(nextRow,nextCol,k-1,move+1);
//            }
//        }
//        for(int i = 0; i < 4; i++){
//            int nextRow = r + drow[i];
//            int nextCol = c + dcol[i];
//            if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length || grid[nextRow][nextCol] == 1) continue;
//
//            dfs(nextRow,nextCol,k,move+1);
//        }
//    }
//}

