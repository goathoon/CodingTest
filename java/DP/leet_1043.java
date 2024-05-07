package DP;

/**
 * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.
 *
 * Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,15,7,9,2,5,10], k = 3
 * Output: 84
 * Explanation: arr becomes [15,15,15,9,10,10,10]
 * Example 2:
 *
 * Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * Output: 83
 * Example 3:
 *
 * Input: arr = [1], k = 1
 * Output: 1
 */
import java.util.*;
public class leet_1043 {
    //Bottom-up
    class Solution1 {
        // O(n*k)
        // i번째 index부터 i+k 까지 돌면서 최대값 찾고, 해당 subarray 길이만큼 최대값을 곱한후, i-1번째 dp 에 최대값 추가시키면 된다.
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int[] dp = new int[arr.length];
            for(int i = 0; i < arr.length; i++){
                int curMax = 0;
                for(int j = i; j < Math.min(i+k,arr.length); j++){
                    curMax = Math.max(curMax,arr[j]);
                    if(i == 0){
                        dp[j] = Math.max(dp[j], curMax*(j-i+1));
                    }
                    else{
                        dp[j] = Math.max(dp[j], dp[i-1]+curMax*(j-i+1));
                    }

                }
            }
            return dp[arr.length-1];
        }
    }
    //Top-down
    class Solution2 {
        static int[] dp;
        public int maxSumAfterPartitioning(int[] arr, int k) {
            dp = new int[arr.length];
            return dfs(0,arr,k);
        }
        public static int dfs(int i, int[] arr, int k){
            if(i >= arr.length) return 0;
            if(dp[i] != 0){
                return dp[i];
            }
            int curMax = 0;
            for(int j = i; j < Math.min(i+k,arr.length); j++){
                curMax = Math.max(curMax, arr[j]);
                dp[i] = Math.max(curMax*(j-i+1)+dfs(j+1, arr, k), dp[i]);
            }

            return dp[i];
        }
    }
}
