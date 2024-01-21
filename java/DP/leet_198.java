package DP;

public class leet_198 {
    class Solution {
        public int rob(int[] nums) {
            int[] dp = new int[nums.length];
            if(nums.length == 1){
                return nums[0];
            }
            dp[0] = nums[0];
            dp[1] = nums[1];
            for(int i = 0; i < nums.length -3; i ++){
                dp[i+2] = Math.max(dp[i]+nums[i+2],dp[i+2]);
                dp[i+3] = Math.max(dp[i]+nums[i+3],dp[i+3]);
            }
            if(nums.length >=3){
                dp[nums.length-1] = Math.max(dp[nums.length-3] + nums[nums.length-1], dp[nums.length-1]);
            }
            return Math.max(dp[nums.length-1],dp[nums.length-2]);
        }
    }
}
