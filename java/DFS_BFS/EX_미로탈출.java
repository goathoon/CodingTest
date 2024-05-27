package DFS_BFS;

import java.io.*;
import java.util.*;

public class EX_미로탈출 {
    public static void main(String[] args) throws IOException {
        class Pos {
            int row;
            int col;

            Pos(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
        int[][] grid = new int[row + 1][col + 1];

        for (int r = 1; r <= row; r++) {
            String s = br.readLine();
            for (int c = 0; c < col; c++) {
                grid[r][c + 1] = s.charAt(c) - '0';
            }
        }
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(1, 1));

        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pos curPos = q.poll();
            int curR = curPos.row;
            int curC = curPos.col;
            if (curR == row && curC == col) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nextR = curR + drow[i];
                int nextC = curC + dcol[i];
                if (nextR == 0 || nextR > row || nextC == 0 || nextC > col) continue;
                if (grid[nextR][nextC] == 1){
                    q.add(new Pos(nextR, nextC));
                    grid[nextR][nextC] = grid[curR][curC]+1;
                }

            }
        }
        System.out.println(grid[row][col]);
    }
    class MySol {
        public static void main(String[] args) throws IOException {
            class Pos {
                int row;
                int col;
                int cost;

                Pos(int row, int col, int cost) {
                    this.row = row;
                    this.col = col;
                    this.cost = cost;
                }
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
            int[][] grid = new int[row + 1][col + 1];

            for (int r = 1; r <= row; r++) {
                String s = br.readLine();
                for (int c = 0; c < col; c++) {
                    grid[r][c + 1] = s.charAt(c) - '0';
                }
            }
            Queue<Pos> q = new LinkedList<>();
            grid[1][1] = 0;
            q.offer(new Pos(1, 1, 1));
            int ans = -1;

            int[] drow = {1, 0, -1, 0};
            int[] dcol = {0, 1, 0, -1};
            while (!q.isEmpty()) {
                Pos curPos = q.poll();
                int curR = curPos.row;
                int curC = curPos.col;
                int curCost = curPos.cost;
                if (curR == row && curC == col) {
                    ans = curCost;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nextR = curR + drow[i];
                    int nextC = curC + dcol[i];
                    if (nextR == 0 || nextR > row || nextC == 0 || nextC > col || grid[nextR][nextC] == 0) continue;

                    q.add(new Pos(nextR, nextC, curCost + 1));
                    grid[nextR][nextC] = 0;
                }
            }
            System.out.println(ans);
        }
    }
}
