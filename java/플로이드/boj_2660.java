package 플로이드;

import java.io.*;
import java.util.*;
public class boj_2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int grid[][] = new int[N+1][N+1];

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                grid[i][j] = Integer.MAX_VALUE;
            }
            grid[i][i] = 0;
        }


        // 친구 관계도 생성
        while(true){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(n1 == -1) break;

            grid[n1][n2] = 1;
            grid[n2][n1] = 1;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(grid[i][k] != Integer.MAX_VALUE && grid[k][j] != Integer.MAX_VALUE){
                        grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                    }
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            int curMax = 0;
            for(int j = 1; j <= N; j++){
                if(curMax < grid[i][j]){
                    curMax = grid[i][j];
                }
            }
            if(curMax == minCost){
                answer.add(i);
            }
            else if(curMax < minCost){
                answer.clear();
                answer.add(i);
                minCost = curMax;
            }
        }
        System.out.println(minCost+ " " +answer.size());
        for(int x : answer){
            System.out.printf("%d ", x);
        }
    }
}
