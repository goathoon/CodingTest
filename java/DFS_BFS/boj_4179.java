package DFS_BFS;
import java.io.*;
import java.util.*;
public class boj_4179 {
    static class Pos {
        int row;
        int col;
        int sec;

        Pos(int row, int col, int sec) {
            this.row = row;
            this.col = col;
            this.sec = sec;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());

        char[][] grid = new char[row][col];
        int[][] fire =  new int[row][col];
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                fire[r][c] = -1;
            }
        }

        Queue<Pos> fires = new LinkedList<>();
        Pos start = null;

        for(int r = 0; r < row; r++){
            grid[r] = br.readLine().toCharArray();
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 'F'){
                    fires.add(new Pos(r,c,0));
                }
                else if(grid[r][c] == 'J'){
                    start = new Pos(r,c,0);
                }
            }
        }

        int[] drow = {1,0,-1,0};
        int[] dcol = {0,1,0,-1};

        while(!fires.isEmpty()){
            Pos f = fires.poll();
            if(fire[f.row][f.col] != -1) continue;
            fire[f.row][f.col] = f.sec;

            for(int i = 0; i < 4; i++){
                int nextRow = f.row + drow[i];
                int nextCol = f.col + dcol[i];
                if(nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) continue;
                if(grid[nextRow][nextCol] == '#') continue;
                fires.add(new Pos(nextRow,nextCol, f.sec + 1));
            }
        }

        Queue<Pos> moves = new LinkedList<>();
        moves.add(start);
        while(!moves.isEmpty()){
            Pos p = moves.poll();
            for(int i = 0; i < 4; i++){
                int nextRow = p.row + drow[i];
                int nextCol = p.col + dcol[i];
                if(nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) {
                    System.out.println(p.sec+1);
                    return;
                }
                if(grid[nextRow][nextCol] == '#') continue;

                if(fire[nextRow][nextCol] != -1 && fire[nextRow][nextCol] <= p.sec+1) continue;

                moves.add(new Pos(nextRow,nextCol,p.sec+1));
                fire[nextRow][nextCol] = 0; //방문처리를 불 배열로 대체
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
