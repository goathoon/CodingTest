package DFS_BFS;
import java.io.*;
import java.util.*;
public class boj_1926 {
    static int[][] grid;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 그래프 행과 열의 수 구하기
        st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
        grid = new int[row][col];
        visit = new boolean[row][col];

        // 그래프 초기화
        for (int r = 0; r < row; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < col; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0, maxSurface = 0;
        // 각 그래프의 원소를 방문하며 dfs 및 넓이 구하기
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 1 && !visit[r][c]){
                    maxSurface = Math.max(dfs(r,c),maxSurface);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxSurface);
    }
    // dfs를 순회하면서, 그림이 연결된 넓이를 반환하는 함수
    public static int dfs(int row, int col){
        // Out Of Index
        if(row < 0 || row >= visit.length || col < 0 || col >= visit[0].length)
            return 0;
        // 이미 방문했거나, 그림이 그려진 위치가 아닌 경우 0을 반환
        if(visit[row][col] || grid[row][col] == 0) return 0;

        visit[row][col] = true;
        // 자기 자신 위치의 넓이 포함하여 주변의 넓이를 계산하는 dfs 시행
        int surface = 1;
        surface += dfs(row+1,col);
        surface += dfs(row-1,col);
        surface += dfs(row,col+1);
        surface += dfs(row,col-1);

        return surface;
    }
}
