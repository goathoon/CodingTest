package DFS_BFS;
import java.io.*;
import java.util.*;
public class boj_6593 {
    static class Pos {
        int f = -1;
        int r = -1;
        int c = -1;
        int cost = 0;
        Pos(){}

        Pos(int f, int r, int c, int cost){
            this.f = f;
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[][][] grid;
        Queue<Pos> q = new LinkedList<>();

        int[] dfloor = {1,-1};
        int[] drow = {1,0,-1,0,0,0};
        int[] dcol = {0,1,0,-1,0,0};

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int floor = Integer.parseInt(st.nextToken()), row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
            if(floor == 0 && row == 0 && col == 0) break;

            grid = new char[floor][row][col];

            Pos startP = new Pos();
            Pos endP = new Pos();

            for(int f = 0; f < floor; f++){
                for(int r = 0; r < row; r++) {
                    String s = br.readLine();
                    for(int c = 0; c < col; c++){
                        grid[f][r][c] = s.charAt(c);
                        if(grid[f][r][c] == 'S'){
                            startP.f = f;
                            startP.r = r;
                            startP.c = c;
                        }
                        else if(grid[f][r][c] == 'E'){
                            endP.f = f;
                            endP.r = r;
                            endP.c = c;
                        }
                    }
                }
                br.readLine();
            }

            q.add(startP);
            boolean isEnd = false;
            while(!q.isEmpty()){
                Pos curP = q.poll();
                int curF = curP.f;
                int curR = curP.r;
                int curC = curP.c;
                int curCost = curP.cost;

                if(curR == endP.r && curC == endP.c && curF == endP.f){
                    System.out.printf("Escaped in %d minute(s).\n", curCost);
                    isEnd = true;
                    break;
                }

                for(int dir = 0; dir < 4; dir++){
                    int nextR = curR + drow[dir];
                    int nextC = curC + dcol[dir];
                    if(nextR < 0 || nextR >= row || nextC < 0 || nextC >= col || grid[curF][nextR][nextC] == '#') continue;
                    q.add(new Pos(curF, nextR, nextC, curCost+1));
                    grid[curF][nextR][nextC] = '#';
                }

                for(int fd = 0; fd < 2; fd++){
                    int nextF = curF + dfloor[fd];
                    if(nextF < 0 || nextF >= floor || grid[nextF][curR][curC] == '#') continue;
                    q.add(new Pos(nextF, curR, curC, curCost+1));
                    grid[nextF][curR][curC] = '#';
                }
            }

            if(!isEnd){
                System.out.println("Trapped!");
            }

            q.clear();
        }
    }

}
