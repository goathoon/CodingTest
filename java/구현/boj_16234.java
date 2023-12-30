package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class boj_16234 {
    static int[][] grid;
    static boolean[][] visited;
    static int L;
    static int R;
    static Stack<Pos> stack;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        visited = new boolean[N][N];
        for (int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < N; c ++){
                grid[n][c] = Integer.parseInt(st.nextToken());
            }
        }
        stack = new Stack<>();
        int answer = 0;
        while(true){
            boolean isFinish = true;
            initVisited(visited);
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c ++){
                    if (!visited[r][c]){
                        dfs(r,c);
                        move(sum);
                        sum = 0;
                    }
                    else{
                        isFinish = false;
                    }
                }
            }
            if(isFinish) break;
            answer ++;
        }
        System.out.println(answer);
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        stack.push(new Pos(r,c));
        sum += grid[r][c];
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};
        for(int i = 0; i < 4; i ++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nr >= visited.length || nc <0 || nc >=visited[0].length || visited[nr][nc]) continue;
            int dif = Math.abs(grid[nr][nc] - grid[r][c]);
            if( L <= dif && dif <= R){
                dfs(nr,nc);
            }
        }
    }
    static void move(int sum){
        int total = stack.size();
        while(!stack.isEmpty()){
            Pos curPos = stack.pop();
            grid[curPos.row][curPos.col] = sum / total;
        }
    }

    static void initVisited(boolean[][] visited){
        for(int r = 0; r < visited.length; r++){
            for(int c = 0; c <visited[0].length; c++){
                visited[r][c] = false;
            }
        }
    }
    static class Pos {
        int row;
        int col;
        Pos(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
}
