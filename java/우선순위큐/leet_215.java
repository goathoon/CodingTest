package 우선순위큐;
import java.util.*;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
public class leet_215 {
    class Solution {

        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int x : nums){
                pq.add(x);
            }
            int answer = 0;
            for(int i = 0; i < k; i++){
                answer = pq.poll();
            }
            return answer;
        }
    }
}
