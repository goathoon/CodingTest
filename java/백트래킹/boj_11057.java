package 백트래킹;
import java.io.*;
import java.util.*;
public class boj_11057 {
    static long [][] dp;
    static final long mod = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        /**
         * 행 : N개의 자리 수
         * 열 : N개의 자리 수의 맨 앞자리 수가 0~9인 경우
         * 값 : N개의 자리 수에서 맨 앞자리 수가 0~9 인 경우, 구할 수 있는 오름 수 개수
         */
        dp = new long[N+1][10];

        long ans = 0;
        for(int start = 0; start <= 9; start++){
            ans += dfs(0,N,start);
        }
        System.out.println(ans % mod);
    }

    /**
     * @param curCnt = 현재까지 처리한 자리의 개수
     * @param maxCnt = 처리해야하는 전체 자리의 개수
     * @param cur = 현재 처리하고 있는 자리의 '수'
     * @return 현재 처리하고 있는 수부터, maxCnt 자리 까지의 오름 수 개수
     */
    public static long dfs(int curCnt, int maxCnt, int cur){
        // cur 수로 시작하는 자리수가 maxCnt-curCnt인 오름 수 개수가 이미 구해졌으면 반환
        if(dp[maxCnt-curCnt][cur] != 0)
            return dp[maxCnt-curCnt][cur];

        // 현재 처리해야 하는 자리가 마지막인 경우 1 반환
        if(curCnt + 1== maxCnt){
            return 1;
        }

        for(int next = cur; next <= 9; next++){
            // next로 시작하는, 자리수가 maxCnt-curCnt인 오름수의 개수
            dp[maxCnt-curCnt][cur] += dfs(curCnt+1, maxCnt, next);
            dp[maxCnt-curCnt][cur] %= mod;
        }
        return dp[maxCnt-curCnt][cur];
    }
}
