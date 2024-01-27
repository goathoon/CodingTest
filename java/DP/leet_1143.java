package DP;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 */

public class leet_1143 {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] t1 = text1.toCharArray();
            char[] t2 = text2.toCharArray();
            int ans = 0;
            int curIdx = 0;
            int[][] dp = new int[text1.length()][text2.length()];

            char c1= t1[0];
            Loop : for(int i2 = 0; i2 < t2.length; i2++){
                if(c1 == t2[i2]){
                    for(int r = i2; r < t2.length; r++){
                        dp[0][r] = 1;
                    }
                    break;
                }
            }

            char c2 = t2[0];
            for(int i1 = 0; i1 < t1.length; i1++){
                if(c2 == t1[i1]){
                    for(int r = i1; r < t1.length; r++){
                        dp[r][0] = 1;
                    }
                    break;
                }
            }

            for(int i1 = 1; i1 < t1.length; i1++){
                for(int i2 = 1; i2 < t2.length; i2++){
                    if(t1[i1] == t2[i2]){
                        dp[i1][i2] = dp[i1-1][i2-1] + 1;
                    }
                    else{
                        dp[i1][i2] = Math.max(dp[i1-1][i2],dp[i1][i2-1]);
                    }
                }
            }
            return dp[t1.length-1][t2.length-1];
        }
    }

    //trick 사용 + 더 간단하게 풀기
    class Solution2 {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();

            // +1 을 추가해서 이따 사용할 dp배열에서 out of bounds 가 나지 않게함.
            int[][] dp = new int[len1+1][len2+1];

            for(int i1 = 1; i1 <= len1; i1++){
                for(int i2 = 1; i2 <= len2; i2++){
                    if(text1.charAt(i1-1) == text2.charAt(i2-1)){
                        dp[i1][i2] = dp[i1-1][i2-1] + 1;
                    }
                    else{
                        dp[i1][i2] = Math.max(dp[i1-1][i2],dp[i1][i2-1]);
                    }
                }
            }
            return dp[len1][len2];
        }
    }

}
