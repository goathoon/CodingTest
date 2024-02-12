package 해시;
import java.util.*;
public class leet_169 {
    class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            int ans = -1;
            for(int n : nums){
                if(map.containsKey(n)){
                    int cnt = map.get(n);
                    map.put(n,cnt+1);
                    if(cnt+1 > nums.length/2){
                        ans = n;
                        break;
                    }
                }
                else{
                    map.put(n,1);
                }
            }
            if (ans == -1){
                return nums[0];
            }
            return ans;
        }
    }
}
