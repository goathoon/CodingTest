package DP;
import java.util.*;

/**
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,2]
 * Explanation: [1,3] is also accepted.
 * Example 2:
 *
 * Input: nums = [1,2,4,8]
 * Output: [1,2,4,8]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * All the integers in nums are unique.
 */
public class leet_368 {
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            class VI implements Comparable<VI>{
                int v;
                int i;
                int prevI;
                VI(int v, int i,int prevI){
                    this.v = v;
                    this.i = i;
                    this.prevI = prevI;
                }
                public int compareTo(VI vi){
                    return this.v - vi.v;
                }
            }

            VI[] arr = new VI[nums.length];
            // dp 배열 원소는 정렬된 수들입니다.
            // dp[i] = 0~i번째 정렬된 원소까지의 최대 집합 원소의 개수
            int[] dp = new int[nums.length];
            for(int i = 0; i < nums.length; i ++){
                arr[i] = new VI(nums[i], i, i);
                dp[i] = 1;
            }
            Arrays.sort(arr);
            Map<Integer,Integer> Num2Arr = new HashMap<>();
            for(int i = 0; i < arr.length; i++){
                Num2Arr.put(arr[i].i,i);
            }
            for(int i = 1; i < nums.length; i++){
                for(int j = i-1; j >= 0; j --){
                    if(arr[i].v % arr[j].v == 0){
                        if(dp[i] < dp[j]+1){
                            dp[i] = dp[j]+1;
                            arr[i].prevI = arr[j].i;
                            // System.out.println("i = " + i + " j = " + j + " " +arr[i].v + " " + arr[j].v + " "  + arr[j].i);
                        }
                    }
                }
            }

            int val = 1;
            int maxI = 0;
            for(int i = 0; i < nums.length; i++){
                if(dp[i] > val){
                    maxI = i;
                    val = dp[i];
                }
            }
            int[] bigToSmall = new int[dp[maxI]];
            // 정렬된 arr에서 실제 배열의 index로 참조
            int nextI = arr[maxI].i;
            int nextArrIdx = maxI;
            for(int i = 0; i < dp[maxI];i++){
                bigToSmall[i] = nums[nextI];
                nextI = arr[nextArrIdx].prevI;
                // 가장 큰 원소의 개수를 가지는 값의 바로 이전 값의 nums index위치를 알아내야함.
                nextArrIdx = Num2Arr.get(nextI);
            }

            System.out.println(Arrays.toString(bigToSmall));
            List<Integer> ans = new ArrayList<>();
            for(int i = bigToSmall.length - 1; i >= 0; i--){
                ans.add(bigToSmall[i]);
            }
            return ans;
        }
    }
    public class leet_368_efficient {
        class Solution {
            static Map<Integer, List<Integer>> map;
            public List<Integer> largestDivisibleSubset(int[] nums) {
                map = new HashMap<>();
                Arrays.sort(nums);
                List<Integer> ansList = new ArrayList<>();;
                for(int i = 0; i < nums.length; i++){
                    List<Integer> tempList = dfs(i,nums);
                    if(tempList.size() > ansList.size()){
                        ansList = tempList;
                    }
                }
                return ansList;
            }
            public List<Integer> dfs(int i, int[] nums){
                if(i == nums.length) return new ArrayList<Integer>();
                if(map.containsKey(i)){
                    return map.get(i);
                }
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                List<Integer> addList = new ArrayList<>();
                for(int j = i+1; j < nums.length; j++){
                    if(nums[j] % nums[i] == 0){
                        List<Integer> tmpList = dfs(j,nums);
                        if(tmpList.size() > addList.size()){
                            addList = tmpList;
                        }
                    }
                }
                list.addAll(addList);
                map.put(i,list);
                return list;
            }
        }
    }

}
