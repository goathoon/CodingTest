package 구현;

import java.io.*;
import java.util.*;

public class EX_상하좌우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N+1][N+1];

        int curR = 1;
        int curC = 1;
        int[] drow = {0,0,-1,1};
        int[] dcol = {-1,1,0,0};
        char[] move = {'L','R','U','D'};
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            char c = st.nextToken().charAt(0);
            for(int d = 0; d < 4; d++){
                if(move[d] == c){
                    if(curR + drow[d] >= 1 && curR + drow[d] <= N && curC + dcol[d] >= 1 && curC + dcol[d] <= N){
                        curR += drow[d];
                        curC += dcol[d];
                    }
                }
            }

        }
        System.out.printf("%d %d",curR, curC);
    }
    class MySol {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[][] grid = new int[N + 1][N + 1];

            int curR = 1;
            int curC = 1;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                char c = st.nextToken().charAt(0);
                switch (c) {
                    case 'R': {
                        if (curC + 1 <= N) curC += 1;
                        break;
                    }
                    case 'U': {
                        if (curR - 1 >= 1) curR -= 1;
                        break;
                    }
                    case 'D': {
                        if (curR + 1 <= N) curR += 1;
                        break;
                    }
                    case 'L': {
                        if (curC - 1 >= 1) curC -= 1;
                        break;
                    }
                }
            }
            System.out.printf("%d %d", curR, curC);
        }
    }
}
