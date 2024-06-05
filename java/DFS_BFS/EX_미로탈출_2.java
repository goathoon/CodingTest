package DFS_BFS;
import java.io.*;
import java.util.*;
public class EX_미로탈출_2 {
    static class Pos{
        int row;
        int col;
        Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
        int[][] grid = new int[row+1][col+1];
        for(int r = 1; r <= row; r++){
            String s = br.readLine();
            for(int c = 1; c <= col; c++){
                grid[r][c] = Character.getNumericValue(s.charAt(c-1));
            }
        }
        Queue<Pos> q = new LinkedList<>();

        int[] drow = {1,0,-1,0};
        int[] dcol = {0,1,0,-1};
        q.offer(new Pos(1,1));
        while(!q.isEmpty()){
            Pos curP = q.poll();
            int curR = curP.row;
            int curC = curP.col;
            if(curR == row && curC == col) break;
            for(int i = 0; i < 4; i++){
                int nextR = curR + drow[i];
                int nextC = curC + dcol[i];
                if(nextR <= 0 || nextR > row || nextC <= 0 || nextC > col || grid[nextR][nextC] != 1) continue;
                q.offer(new Pos(nextR,nextC));
                grid[nextR][nextC] = grid[curR][curC] + 1;
            }
        }
        System.out.println(grid[row][col]);
    }
}
