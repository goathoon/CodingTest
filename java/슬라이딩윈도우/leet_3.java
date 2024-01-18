package 슬라이딩윈도우;
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
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int l = 0, r = 0, len = s.length(), curLen = 0, maxLen = 0;
            Set<Character> set = new HashSet<>();
            while(r < len){
                char c = s.charAt(r);
                if(!set.contains(c)){
                    set.add(c);
                    curLen = r - l + 1;
                    r++;
                    maxLen = Math.max(curLen,maxLen);
                }
                else{
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            return maxLen;
        }
    }
}
