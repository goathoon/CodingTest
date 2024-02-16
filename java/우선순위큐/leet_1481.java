package 우선순위큐;
import java.util.*;

/**
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 * Example 2:
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 */
public class leet_1481 {
    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            class NumberCount implements Comparable<NumberCount>{
                int num;
                int cnt;

                NumberCount(int num, int cnt){
                    this.num = num;
                    this.cnt = cnt;
                }

                public int compareTo(NumberCount numberCount){
                    return this.cnt - numberCount.cnt;
                }
            }
            Map<Integer,Integer> numCnt = new HashMap<>();
            PriorityQueue<NumberCount> pq = new PriorityQueue<>();
            for(int x : arr){
                if(numCnt.containsKey(x)){
                    numCnt.put(x,numCnt.get(x)+1);
                }
                else{
                    numCnt.put(x,1);
                }
            }
            for(int num : numCnt.keySet()){
                pq.add(new NumberCount(num,numCnt.get(num)));
            }
            while(k > 0){
                NumberCount nc = pq.poll();
                if(nc.cnt > k){
                    return pq.size() + 1;
                }
                k -= nc.cnt;
            }
            return pq.size();

        }
    }
}
