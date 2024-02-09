package 브루트포스;
import java.util.*;
public class leet_368 {
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
