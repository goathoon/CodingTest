package 구간합;
import java.util.*;
public class leet_2971 {
    class Solution {
        public long largestPerimeter(int[] nums) {
            long[] dp = new long[nums.length];
            Arrays.sort(nums);
            long ans = -1;
            dp[0] = nums[0];
            dp[1] = dp[0] + nums[1];
            for(int i = 2; i < nums.length; i++){
                dp[i] = dp[i-1] + nums[i];
                if(nums[i] < dp[i-1]) ans = dp[i];
            }
            return ans;
        }
    }
}
