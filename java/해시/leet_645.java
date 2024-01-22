package 해시;
import java.util.*;
public class leet_645 {

    class Solution {
        public int[] findErrorNums(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            int dup = 0;
            int ex = 0;
            for(int i = 1; i <= nums.length; i++){
                map.put(i,0);
            }

            for(int x : nums){
                if(map.get(x) == 0){
                    map.put(x,1);
                }
                else{
                    map.put(x,2);
                    dup = x;
                }
            }
            for(int i = 1; i <= nums.length; i++){
                if(map.get(i) == 0){
                    ex = i;
                }
            }
            return new int[]{dup,ex};
        }
    }
}
