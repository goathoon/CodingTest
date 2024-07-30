package DP;
import java.util.*;
public class boj_1660 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int start = 1;
        int add = 2;
        List<Integer> sum = new ArrayList<>();
        sum.add(start);

        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[start] = 1;
        dp[0] = 0;
        int last = start;
        while (true) {
            start += add;
            add += 1;

            if (last + start > n) break;
            last += start;
            dp[last] = 1;
            sum.add(last);
        }

        for(int i = 1; i <= n; i++){
            for(int s : sum){
                if(i - s < 0 || dp[i-s] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i-s]+1, dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
