package DP;
import java.io.*;
import java.util.*;
public class boj_1535 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] p = new int[N+1][2];
        // N명의 사람 = row, 0~100의 열 = 체력, 원소 값 = 기쁨
        int[][] dp = new int[N+1][101];
        st = new StringTokenizer(br.readLine(), " ");
        for(int n = 1; n <= N; n++){
            p[n][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int n = 1; n <= N; n++){
            p[n][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 100; i++){
            dp[0][i] = -1;
        }
        // 0명의 사람선택, 현재 체력 100부터 시작.
        dp[0][100] = 0;
        for(int n = 1; n <= N; n++){
            int hurt = p[n][0];
            int pleasure = p[n][1];
            for(int h = 1; h <= 100; h++){
                if(dp[n-1][h] != -1 ){
                    // n번째 사람을 선택할 때
                    if(h>=hurt) {
                        dp[n][h - hurt] = Math.max(dp[n][h - hurt], dp[n - 1][h] + pleasure);
                    }
                    // 그냥 넘길 때
                    dp[n][h] = Math.max(dp[n-1][h], dp[n][h]);
                }
            }
        }
        int ans = 0;
        for(int h = 1; h <= 100; h++){
            ans = Math.max(ans,dp[N][h]);
        }
        System.out.println(ans);
    }

    /**
     * https://kjh8673a.github.io/algorithm/2023-06-29-boj-1535
     **/

    // 줄어든 체력이 100이 될 때까지 시도하는 거라 knap-sack으로 생각 가능
    class Solution2 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine());
            int[] L = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                L[i] = Integer.parseInt(st.nextToken());
            }
            int[] J = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                J[i] = Integer.parseInt(st.nextToken());
            }
            // col은 줄어든 체력을 의미함.
            int[][] dp = new int[N + 1][101];
            // n 번째 사람 선택하기 시작.
            for (int n = 1; n <= N; n++) {
                for (int j = 1; j <= 100; j++) {
                    //줄어든 체력이 해당 사람에게 인사를 하면서 줄어든 체력보다 클때 (인사 한경우)
                    if (j >= L[n]) {
                        dp[n][j] = Math.max(dp[n - 1][j], dp[n - 1][j - L[n]] + J[n]);
                    } else {
                        dp[n][j] = dp[n - 1][j];
                    }
                }
            }
            System.out.println(dp[N][99]);
        }
    }
}
