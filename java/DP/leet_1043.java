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
                int curMax = arr[i];
                for(int n = i; n < Math.min(i+k,arr.length); n++){
                    if(curMax < arr[n]){
                        curMax = arr[n];
                    }
                    dp[n] = i-1 >= 0 ? Math.max(dp[n],(n-i+1) * curMax + dp[i-1]) : Math.max(dp[n],(n-i+1) * curMax);
                }
            }
            return dp[arr.length-1];
        }
    }
    //Top-down
    class Solution2 {
        static Map<Integer,Integer> map;
        public int maxSumAfterPartitioning(int[] arr, int k) {
            map = new HashMap<>();
            return dfs(0,arr,k);
        }
        public int dfs(int i, int[] arr, int k){
            if(i == arr.length){
                return 0;
            }
            if(map.containsKey(i)){
                return map.get(i);
            }
            int curMax = 0;
            int curVal = 0;
            for(int j = i; j < Math.min(i+k,arr.length); j++){
                curMax = Math.max(curMax,arr[j]);
                curVal = Math.max(curVal,(j-i+1) * curMax + dfs(j+1,arr,k));
            }
            map.put(i,curVal);
            return curVal;
        }
    }
}
