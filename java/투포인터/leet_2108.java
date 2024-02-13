package 투포인터;

/**
 * Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
 *
 * A string is palindromic if it reads the same forward and backward.
 */

public class leet_2108 {
    class Solution {
        public String firstPalindrome(String[] words) {
            for(String s : words){
                if(isPal(s)){
                    return s;
                }
            }
            return "";
        }
        public boolean isPal(String s){
            char[] arr = s.toCharArray();
            int l = 0, r = arr.length-1;
            while(l <= r){
                if(arr[l] != arr[r]){
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }
}
