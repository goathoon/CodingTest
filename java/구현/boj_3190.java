package 구현;
import java.util.*;
import java.io.*;
public class boj_3190 {
        public static void main(String[] args) throws IOException {
            class Dir{
                int sec;
                char dir;
                Dir(int sec, char dir){
                    this.sec = sec;
                    this.dir = dir;
                }
            }
            class Pos{
                int row;
                int col;
                Pos(int row, int col){
                    this.row = row;
                    this.col = col;
                }
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int [][] grid = new int[N+1][N+1];
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                grid[row][col] = 2; // 사과
            }
            int D = Integer.parseInt(br.readLine());
            Queue<Dir> dirQ = new LinkedList<>();
            Queue<Pos> snake = new LinkedList<>();
            for(int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int sec = Integer.parseInt(st.nextToken());
                char dir = st.nextToken().charAt(0);
                dirQ.add(new Dir(sec, dir));
            }
            Pos[] pos = new Pos[]{new Pos(0,1),new Pos(1,0), new Pos(0,-1), new Pos(-1,0)};

            int answer = 0;
            int nowDir = 0;
            int startRow = 1;
            int startCol = 1;
            snake.add(new Pos(startRow,startCol));
            while(true){
                int nextRow = startRow + pos[nowDir].row;
                int nextCol = startCol + pos[nowDir].col;
                if(nextRow <= 0 || nextRow > N || nextCol <= 0 || nextCol > N || grid[nextRow][nextCol] == 1){
                    System.out.println(answer + 1);
                    return;
                }

                if(grid[nextRow][nextCol] == 0){
                    Pos lastPos = snake.poll();
                    grid[lastPos.row][lastPos.col] = 0;
                }
                grid[nextRow][nextCol] = 1;
                snake.add(new Pos(nextRow,nextCol));
                answer ++;
                if(!dirQ.isEmpty() && dirQ.peek().sec == answer){
                    Dir nextDir = dirQ.poll();
                    switch(nextDir.dir){
                        case 'D' :
                            nowDir++;
                            if(nowDir == 4){
                                nowDir = 0;
                            }
                            break;
                        case 'L' :
                            nowDir--;
                            if(nowDir == -1){
                                nowDir = 3;
                            }
                            break;
                    }
                }
                startRow = nextRow;
                startCol = nextCol;

            }
        }
}
