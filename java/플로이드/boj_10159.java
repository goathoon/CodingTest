package 플로이드;

import java.io.*;
import java.util.*;

public class boj_10159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] grid = new int[N+1][N+1];
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            grid[s][e] = 1;
            grid[e][s] = -1;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(grid[i][j] == 0){
                        if(grid[i][k] == 1 && grid[k][j] == 1){
                            grid[i][j] = 1;
                        }
                        else if(grid[i][k] == -1 && grid[k][j] == -1){
                            grid[i][j] = -1;
                        }
                    }
                }
            }
        }

        for(int n = 1; n <= N; n++){
            int cnt = 0;
            for(int i = 1; i <= N; i++){
                if(i == n) continue;
                if(grid[n][i] == 0) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
