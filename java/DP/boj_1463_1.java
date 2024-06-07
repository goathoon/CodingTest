package DP;
import java.io.*;
import java.util.*;
public class boj_1463_1 {
    static int[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ans = new int[N+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        dfs(N,0);
        System.out.println(ans[1]);
    }
    public static void dfs(int N, int cnt){
        if(ans[N] <= cnt || N == 0) return;
        ans[N] = cnt;
        if(N % 3 == 0){
            dfs(N / 3, cnt+1);
        }
        if(N % 2 == 0){
            dfs(N / 2, cnt+1);
        }
        dfs(N-1, cnt+1);
    }
    class BottomUp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int[] dp = new int[N + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[1] = 0;
            for (int i = 2; i <= N; i++) {
                if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
                }
                if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
                }
                dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            }
            System.out.println(dp[N]);
        }
    }
}
