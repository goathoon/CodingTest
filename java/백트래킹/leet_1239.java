package 백트래킹;
import java.util.*;
public class leet_1239 {
    class Solution {
        static int answer;
        public int maxLength(List<String> arr) {
            Set<Character> set = new HashSet<>();
            answer = 0;

            dfs(0,0,arr,new HashSet<Character>());
            return answer;
        }

        static void dfs(int idx, int cnt, List<String> arr, Set<Character> set){
            if(idx == arr.size()){
                if(set.size() == cnt){
                    answer = Math.max(cnt,answer);
                    return;
                }
                return;
            }

            Set<Character> addSet = new HashSet<>();

            dfs(idx+1,cnt,arr,set); //해당 index는 건너뜀

            String s = arr.get(idx);
            char[] chars = s.toCharArray();
            for(int j = 0; j <chars.length; j ++){
                if(set.contains(chars[j]) || addSet.contains(chars[j])) return;
                addSet.add(chars[j]);
            }
            set.addAll(addSet);
            dfs(idx+1,cnt+ chars.length, arr, set); // 해당 index를 subsequence로 선택

            set.removeAll(addSet);
        }
    }
}
