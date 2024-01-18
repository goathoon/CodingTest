package 큐;
import java.util.*;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class leet_3 {

    class Solution {제
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            Queue<Character> q = new LinkedList<>();

            char[] arr = s.toCharArray();
            int answer = 0;
            for(char c: arr){
                if(set.contains(c)){
                    while(q.peek() != c){
                        char p = q.poll();
                        set.remove(p);
                    }
                    q.poll();
                    set.remove(c);
                }
                set.add(c);
                q.add(c);
                answer = Math.max(q.size(),answer);
            }

            return answer;
        }
    }
}
