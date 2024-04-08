package 구현;

import java.util.*;
import java.io.*;
public class boj_16235 {
    public static void main(String[] args) throws IOException {
        class Tree{
            int row;
            int col;
            int age;
            Tree(int row, int col, int age){
                this.row = row;
                this.col = col;
                this.age = age;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] grow = new int[N+1][N+1];
        int[][] originalGrow = new int[N+1][N+1];
        Deque<Tree> trees = new LinkedList<>();
        for(int r = 1; r <= N; r++){
            st = new StringTokenizer(br.readLine(), " " );
            for(int c = 1; c <= N; c++){
                grow[r][c] = 5;
                originalGrow[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(row,col,age));
        }
        int[] drow = {-1,-1,0,1,1,1,0,-1};
        int[] dcol = {0,1,1,1,0,-1,-1,-1};

        for(int k = 0; k < K; k++){
            Queue<Tree> dieTrees = new LinkedList<>();
            for(int i = 0; i < trees.size();){
                Tree curTree = trees.pollFirst();
                int curRow = curTree.row;
                int curCol = curTree.col;
                if(grow[curRow][curCol] >= curTree.age){
                    grow[curRow][curCol] -= curTree.age;
                    trees.addLast(new Tree(curRow,curCol,curTree.age + 1));
                    i++;
                }
                else{
                    dieTrees.add(curTree);
                }
            }
            for(Tree t : dieTrees){
                grow[t.row][t.col] += t.age / 2;
            }
            LinkedList<Tree> temp = new LinkedList<>();
            for(Tree t : trees){
                if(t.age % 5 == 0){
                    temp.add(t);
                }
            }
            for(Tree t : temp){
                if(t.age % 5 == 0){
                    for (int i = 0; i < 8; i++) {
                        int nextRow = drow[i] + t.row;
                        int nextCol = dcol[i] + t.col;
                        if (nextRow >= 1 && nextRow<= N && nextCol >= 1 && nextCol <= N) {
                            trees.addFirst(new Tree(nextRow, nextCol, 1));
                        }
                    }
                }
            }
            for(int r = 1; r <= N; r++){
                for(int c = 1; c <= N; c++){
                    grow[r][c] += originalGrow[r][c];
                }
            }
        }
        System.out.println(trees.size());
    }
}
