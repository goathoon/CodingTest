package DFS_BFS;
import java.io.*;
import java.util.*;
class Pos{
    int row;
    int col;
    int val;
    Pos(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
public class boj_17265 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] grid = new char[N][N];
        int[][] maxDP = new int[N][N];
        int[][] minDP = new int[N][N];

        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                minDP[r][c] = Integer.MAX_VALUE;
                maxDP[r][c] = Integer.MIN_VALUE;
            }
        }

        StringTokenizer st;
        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < N; c++){
                grid[r][c] = st.nextToken().charAt(0);
            }
        }

        Queue<Pos> q = new LinkedList<>();
        int start = Character.getNumericValue(grid[0][0]);
        q.add(new Pos(0,0, start));
        maxDP[0][0] = start;
        minDP[0][0] = start;
        while(!q.isEmpty()){
            Pos curPos = q.poll();
            int curRow = curPos.row, curCol = curPos.col, curVal = curPos.val;
            if(maxDP[curRow][curCol] == curVal || minDP[curRow][curCol] == curVal) {
                if (curRow + 2 < N) {
                    int nextVal = cal(curVal, Character.getNumericValue(grid[curRow+2][curCol]), grid[curRow+1][curCol]);
                    if(maxDP[curRow+2][curCol] < nextVal){
                        maxDP[curRow+2][curCol] = nextVal;
                        q.offer(new Pos(curRow+2,curCol, nextVal));
                    }
                    if(minDP[curRow+2][curCol] > nextVal){
                        minDP[curRow+2][curCol] = nextVal;
                        q.offer(new Pos(curRow+2,curCol, nextVal));
                    }
                }
                if (curRow + 1 < N && curCol + 1 < N) {
                    int nextVal1 = cal(curVal, Character.getNumericValue(grid[curRow+1][curCol+1]), grid[curRow+1][curCol]);
                    if(maxDP[curRow+1][curCol+1] < nextVal1){
                        maxDP[curRow+1][curCol+1] = nextVal1;
                        q.offer(new Pos(curRow+1,curCol+1, nextVal1));
                    }
                    if(minDP[curRow+1][curCol+1] > nextVal1){
                        minDP[curRow+1][curCol+1] = nextVal1;
                        q.offer(new Pos(curRow+1,curCol+1, nextVal1));
                    }

                    int nextVal2 = cal(curVal, Character.getNumericValue(grid[curRow+1][curCol+1]), grid[curRow][curCol+1]);
                    if(maxDP[curRow+1][curCol+1] < nextVal2){
                        maxDP[curRow+1][curCol+1] = nextVal2;
                        q.offer(new Pos(curRow+1,curCol+1, nextVal2));
                    }
                    if(minDP[curRow+1][curCol+1] > nextVal2){
                        minDP[curRow+1][curCol+1] = nextVal2;
                        q.offer(new Pos(curRow+1,curCol+1, nextVal2));
                    }
                }
                if (curCol + 2 < N) {
                    int nextVal = cal(curVal, Character.getNumericValue(grid[curRow][curCol+2]), grid[curRow][curCol+1]);
                    if(maxDP[curRow][curCol+2] < nextVal){
                        maxDP[curRow][curCol+2] = nextVal;
                        q.offer(new Pos(curRow,curCol+2, nextVal));
                    }
                    if(minDP[curRow][curCol+2] > nextVal){
                        minDP[curRow][curCol+2] = nextVal;
                        q.offer(new Pos(curRow,curCol+2, nextVal));
                    }
                }
            }
        }
        System.out.println(maxDP[N-1][N-1] + " " + minDP[N-1][N-1]);
    }
    public static int cal(int x, int y, char op){
        switch(op){
            case '+' : {
                return x + y;
            }
            case '-' : {
                return x - y;
            }
            case '*' : {
                return x * y;
            }
        }
        return -1;
    }
}
