package 투포인터;

/**
 * 가로길이가 큰 것이 일단 좋다.
 * 그래서 왼쪽 오른쪽 두가지 포인터를 양 끝값으로 잡고,
 * 양쪽 벽중 낮은 높이에 있는 것을 움직여가며 큰 높이로 갱신시켜나가는 것이 필요하다.
 */
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
