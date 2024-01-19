package DP;

/**
 * Given a string s, return the longest
 * palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

public class leet_5 {
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            int maxLen = 1;
            String answer = s.substring(0,1);

            // row 부터 col 까지 substring의 palindrom 여부
            boolean[][] dp = new boolean[n][n];

            for(int len = 0; len < n; len++){
                for(int start = 0; start < n - len; start++){
                    int end = len + start;
                    if(end == start){
                        dp[start][end] = true;
                    }else if(end == start+1){
                        if(s.charAt(start) == s.charAt(end)){
                            dp[start][end] = true;
                            answer = s.substring(start,end+1);
                            maxLen = Math.max(maxLen, end-start+1);
                        }
                    }
                    else{
                        if(s.charAt(start) == s.charAt(end) && dp[start+1][end-1]){
                            dp[start][end] = true;
                            maxLen = Math.max(maxLen, end-start+1);
                            if(maxLen == end-start+1){
                                answer = s.substring(start,end+1);
                            }
                        }
                    }
                }
            }
            return answer;
        }
    }
}

