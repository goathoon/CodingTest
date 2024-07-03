package 투포인터;
import java.util.*;
public class leet_1438 {
    class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;

        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();

        // 투포인터 + deque 사용
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            while(!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[r]){
                maxQ.pollLast();
            }
            maxQ.offerLast(r);

            while(!minQ.isEmpty() && nums[minQ.peekLast()] > nums[r]){
                minQ.pollLast();
            }
            minQ.offerLast(r);

            while(nums[maxQ.peekFirst()]-nums[minQ.peekFirst()] > limit){
                l++;
                if(maxQ.peekFirst() < l){
                    maxQ.pollFirst();
                }
                if(minQ.peekFirst() < l){
                    minQ.pollFirst();
                }
            }
            ans = Math.max(ans,r - l + 1);
        }
        return ans;
    }
}
}
