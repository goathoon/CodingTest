package 투포인터;

public class leet_2149 {
    class Solution {
        public int[] rearrangeArray(int[] nums) {
            int p = 0;
            int n = 1;
            int[] arr = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > 0){
                    arr[p] = nums[i];
                    p += 2;
                }
                else{
                    arr[n] = nums[i];
                    n += 2;
                }
            }
            return arr;
        }
    }
}
