package DFS_BFS;
import java.io.*;
import java.util.*;
public class softeer_나무조경 {


    public class Main {
        static int[] drow = {1,0};
        static int[] dcol = {0,1};
        static int ans = 0;
        static int[][] grid;
        static boolean[][] visit;
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            grid = new int[N][N];
            visit = new boolean[N][N];
            for(int r = 0; r < N; r++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int c = 0; c < N; c++){
                    grid[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0,0);
            System.out.println(ans);
            return;

        }
        private static void dfs(int sum, int depth){
            if(depth == 4){
                ans = Math.max(ans,sum);
                return;
            }
            for(int r = 0; r < grid.length; r++){
                for(int c = 0; c < grid[0].length; c++){
                    if(!visit[r][c]){
                        for(int i = 0; i < 2; i++){
                            int nextR = r + drow[i];
                            int nextC = c + dcol[i];
                            if(nextR < 0 || nextR >= grid.length || nextC < 0 || nextC >= grid[0].length || visit[nextR][nextC]){
                                continue;
                            }
                            visit[nextR][nextC] = true;
                            visit[r][c] = true;
                            dfs(grid[r][c]+grid[nextR][nextC]+sum, depth+1);
                            visit[nextR][nextC] = false;
                            visit[r][c] = false;
                        }
                    }
                }
            }
            ans = Math.max(ans,sum);
        }
    }
}
