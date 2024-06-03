package 구현;
import java.io.*;
import java.util.*;
public class boj_22342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        int[][] grid = new int[M+2][N+1];
        int[][] output = new int[M+2][N+1];
        for(int m = 1; m <= M; m++){
            String s = br.readLine();
            for(int n = 1; n <= N; n++){
                grid[m][n] = Character.getNumericValue(s.charAt(n-1));
            }
        }
        // 입력 값중 최댓값 자신의 저장값이다.
        // 출력값은 저장값의 grid 가중치 합을 더한 것이 출력값이다.

        //1열 출력값 저장 (입력값이 0이므로, output은 가중치와 같다)
        for(int row = 1; row <= M; row++){
            output[row][1] = grid[row][1];
        }

        for(int col = 2; col <= N; col++){
            for(int row = 1; row <= M; row ++){
                output[row][col] = Math.max(Math.max(output[row-1][col-1], output[row][col-1]), output[row+1][col-1]);
                output[row][col] += grid[row][col];
            }
        }
        int ans = 0;
        for(int row = 1; row <= M; row++){
            ans = Math.max(ans, output[row][N] - grid[row][N]);
        }
        System.out.println(ans);
    }
}
