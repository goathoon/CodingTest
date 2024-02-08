package DP;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 */
public class leet_279 {
    // Top-Down 방식 TLE줄이기 위한 노력
    class Solution {
        static int[] dp;
        public int numSquares(int n) {
            dp = new int[n+1];
            for(int i = 0; i < dp.length; i++){
                dp[i] = Integer.MAX_VALUE;
            }
            return dfs(n);
        }
        public int dfs(int n){
            if(n==0) return 0;
            if(dp[n] != Integer.MAX_VALUE) return dp[n];

            for(int i = 1; i * i <= n; i++){
                dp[n] = Math.min(dp[n], dfs(n-i*i)+1);
            }
            return dp[n];
        }
    }
}
