package 투포인터;

public class leet_11 {
    class Solution {
        public int maxArea(int[] height) {
            int l = 0;
            int r = height.length -1;
            int maxVal = (r-l) * Math.min(height[l], height[r]);
            while(l < r){
                if (height[l] <= height[r]){
                    l++;
                }
                else{
                    r--;
                }
                int nowArea = (r-l) * Math.min(height[l], height[r]);
                if(maxVal < nowArea){
                    maxVal = nowArea;
                }

            }
            return maxVal;
        }
    }
}
