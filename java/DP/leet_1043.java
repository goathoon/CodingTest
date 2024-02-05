package DP;

public class leet_1043 {
    class Solution {
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
}
