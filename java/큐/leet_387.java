package 큐;
import java.util.*;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
public class leet_387 {
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character,Boolean> map = new HashMap<>();
            Queue<Character> q = new LinkedList<>();
            for(int i = 0; i < s.length(); i++){
                char curChar = s.charAt(i);
                if(map.containsKey(curChar)){
                    map.put(curChar,false);
                }
                else{
                    map.put(curChar,true);
                }
                q.add(curChar);
            }
            int idx = 0;
            while(!q.isEmpty()){
                char curC = q.poll();
                if(map.get(curC)){
                    return idx;
                }
                idx++;
            }
            return -1;
        }
    }
}
