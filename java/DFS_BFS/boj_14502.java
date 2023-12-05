package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14502 {
    static List<Point[]> walls = new ArrayList<Point[]>();
    static int emptyCnt = 0;
    static int poisonCnt = 0;
    static class Point{
        int r;
        int c;
        Point(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] originGrid = new int[row][col];
        List<Point> emptyLists = new ArrayList<Point>();
        for(int r = 0; r < row; r ++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c< col; c++){
                originGrid[r][c] = Integer.parseInt(st.nextToken());
                if(originGrid[r][c] == 0){
                    emptyLists.add(new Point(r,c));
                    emptyCnt ++;
                }
            }
        }
        int[][] grid = new int[row][col];
        copyArray(originGrid, grid);

        Point[] emptyPoints = emptyLists.toArray(new Point[0]);
        boolean[] visitedComb = new boolean[emptyPoints.length];
        combinations(emptyPoints,visitedComb,0,0);
        boolean[][] visited = new boolean[row][col];
        int maxEmpty = 0;
        int minPoison = 100;
        for(Point[] points: walls){
            Point first = points[0];
            Point second = points[1];
            Point third = points[2];
            grid[first.r][first.c] = 1;
            grid[second.r][second.c] = 1;
            grid[third.r][third.c] = 1;
            for(int r = 0; r< grid.length; r ++){
                for (int c = 0 ;c <grid[0].length; c++){
                    if(grid[r][c] == 2){
                        dfs(grid,r,c,visited);
                    }
                }
            }
            minPoison = Math.min(poisonCnt,minPoison);
            poisonCnt = 0;
            copyArray(originGrid, grid);
            initVisited(visited);

        }
        System.out.println(emptyCnt - minPoison - 3);

    }

    private static void initVisited(boolean[][] visited) {
        for(int r = 0 ; r < visited.length; r ++){
            Arrays.fill(visited[r],false);
        }
    }

    private static void copyArray(int[][] originGrid, int[][] grid) {
        for(int i = 0; i < grid.length; i ++){
            System.arraycopy(originGrid[i],0, grid[i],0, originGrid[i].length);
        }
    }

    static void combinations(Point[] emptyPoints, boolean[] visited, int curIdx, int nowDepth){
        if(nowDepth == 3){
            Point[] arr = new Point[3];
            int insertIdx = 0;
            for (int idx = 0; idx < visited.length; idx++){
                if (visited[idx]){
                    arr[insertIdx++] = emptyPoints[idx];
                }
            }
            walls.add(arr);
            return;
        }

        for(int idx = curIdx; idx < visited.length; idx++){
            visited[idx] = true;
            combinations(emptyPoints,visited,idx+1,nowDepth+1);
            visited[idx] = false;
        }
    }

    static void dfs(int[][] grid, int row, int col, boolean[][] visited){
        visited[row][col] = true;
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,-1,0,1};
        for(int i = 0; i<4; i++){
            int nextRow = row + drow[i];
            int nextCol = col + dcol[i];
            if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length
                || visited[nextRow][nextCol] == true || grid[nextRow][nextCol] != 0){
                continue;
            }
            grid[nextRow][nextCol] = 2;
            dfs(grid,nextRow,nextCol,visited);
            poisonCnt ++;
        }
    }
}
