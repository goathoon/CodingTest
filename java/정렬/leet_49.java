package 정렬;
import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class leet_49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            int listIdx = -1;
            List<List<String>> list = new LinkedList<>();
            Map<String,Integer> map = new HashMap<>();
            for(String s : strs){
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String sortString = new String(chars);
                if(map.containsKey(sortString)){
                    int idx = map.get(sortString);
                    list.get(idx).add(s);
                }
                else{
                    list.add(new LinkedList<>());
                    listIdx++;
                    list.get(listIdx).add(s);
                    map.put(sortString,listIdx);
                }
            }
            return list;
        }
    }
}
