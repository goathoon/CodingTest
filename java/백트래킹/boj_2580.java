package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2580 {
    static int[][] grid = new int[9][9];
    static class Empty{
        int row;
        int col;
        Empty(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static Deque<Empty> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        q = new LinkedList<>();
        for(int r = 0; r < 9; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < 9; c++){
                int value = Integer.parseInt(st.nextToken());
                grid[r][c] = value;
                if(value == 0){
                    q.add(new Empty(r,c));
                }
            }
        }
        dfs(q);
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                System.out.printf("%d ", grid[r][c]);
            }
            System.out.println();
        }
    }
    public static boolean dfs(Deque<Empty> q){
        if(q.isEmpty()){
            return true;
        }
        Empty empty = q.poll();
        int emptyRow = empty.row;
        int emptyCol = empty.col;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> squareSet = new HashSet<>();
        for(int r = 0; r < 9; r++){
            rowSet.add(grid[r][emptyCol]);
        }

        for(int c = 0; c < 9; c++){
            colSet.add(grid[emptyRow][c]);
        }
        for(int r = 3*(emptyRow/3); r < 3*(emptyRow/3+1); r++){
            for(int c = 3*(emptyCol/3); c < 3*(emptyCol/3+1); c++){
                squareSet.add(grid[r][c]);
            }
        }
        for(int i = 1; i <= 9; i++){
            if(!(colSet.contains(i) || rowSet.contains(i) || squareSet.contains(i))){
                grid[emptyRow][emptyCol] = i;
                Empty nextEmpty = q.peek();
                if(dfs(q)) {
                    return true;
                }
                else{
                    q.addFirst(nextEmpty);
                    grid[emptyRow][emptyCol] = 0;
                }
            }
        }

        return false;
    }
}
