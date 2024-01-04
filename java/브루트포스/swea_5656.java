package 브루트포스;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class swea_5656 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T;
            T=sc.nextInt();
            int[][] grid;
            boolean[][] bomb;
            for(int test_case = 1; test_case <= T; test_case++)
            {
                int N = sc.nextInt();
                int W = sc.nextInt();
                int H = sc.nextInt();
                grid = new int[H][W];
                bomb = new boolean[H][W];
                for(int h = 0; h < H; h++){
                    for(int w = 0; w < W; w++){
                        grid[h][w] = sc.nextInt();
                    }
                }
                List<int[]> throwCase = new LinkedList<>();
                int[] arr = new int[N];
                permutation(arr,throwCase,0,W);
                int answer = 100000;
                int[][] cloneGrid = new int[H][W];
                int[][] ansGrid = new int[H][W];
                for(int[] a : throwCase) {
                    for (int h = 0; h < H; h++) {
                        for (int w = 0; w < W; w++) {
                            cloneGrid[h][w] = grid[h][w];
                        }
                    }
                    for (int throwPos : a) {
                        initBomb(bomb);
                        for (int h = 0; h < H; h++) {
                            if (cloneGrid[h][throwPos] != 0) {
                                breakGrid(cloneGrid, bomb, h, throwPos);
                                break;
                            }
                        }
                        getDown(cloneGrid);
                    }
                    int candAns = countBlock(cloneGrid);
                    answer = Math.min(answer, candAns);
                }

                System.out.printf("#%d %d%n",test_case, answer);
            }
        }
        static void initBomb(boolean[][]bomb){
            for(int h = 0 ; h< bomb.length; h++){
                for(int w = 0; w < bomb[0].length; w ++){
                    bomb[h][w] = false;
                }
            }
        }
        static int countBlock(int[][] grid){
            int cnt = 0;
            for(int h = 0; h < grid.length; h++){
                for(int w= 0; w < grid[0].length; w ++){
                    if(grid[h][w] != 0 ){
                        cnt ++;
                    }
                }
            }
            return cnt;
        }
        static void getDown(int[][] grid){
            for(int w = 0; w < grid[0].length; w ++){
                int bottom = grid.length-1;
                for(int h = grid.length-1; h >= 0; h--){
                    if(grid[h][w] == 0 && h+1 <= grid.length-1 && grid[h+1][w] != 0) {
                        bottom = h;
                    }
                    else if (grid[h][w] != 0 && h+1 <= grid.length-1 && grid[h+1][w] == 0){
                        grid[bottom--][w] = grid[h][w];
                        grid[h][w] = 0;
                    }
                }
            }
        }
        static void breakGrid(int[][] grid,boolean[][] bomb, int h, int w){
            bomb[h][w] = true;
            int s = grid[h][w];
            grid[h][w] = 0;
            for(int splash = 1; splash < s; splash ++){
                if(h+splash < grid.length && grid[h+splash][w] != 0 && !bomb[h+splash][w] ) breakGrid(grid,bomb,h+splash,w);
                if(h-splash >= 0 && grid[h-splash][w] != 0 && !bomb[h-splash][w]) breakGrid(grid,bomb,h-splash,w);
                if(w-splash >= 0 && grid[h][w-splash] != 0 && !bomb[h][w-splash] ) breakGrid(grid,bomb,h,w-splash);
                if(w+splash < grid[0].length && grid[h][w+splash] != 0 && !bomb[h][w+splash] ) breakGrid(grid,bomb,h,w+splash);
            }
        }
        static void permutation(int[] arr, List<int[]> caseThrow, int curDepth,int W){

            if(curDepth == arr.length){
                int[] caseArray = arr.clone();
                caseThrow.add(caseArray);
                return;
            }
            else{
                for(int i = 0; i < W; i ++){
                    arr[curDepth] = i;
                    permutation(arr,caseThrow,curDepth+1,W);
                }
            }
        }
    }

