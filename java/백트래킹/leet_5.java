package 백트래킹;

/**
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
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


/*
    두가지 케이스로 나눈다.
    (1) 문자 하나 기준으로 퍼지면서 서칭
    (2) palindrome인 두 문자 기준으로 퍼지면서 서칭
*/
public class leet_5 {

    class Solution {
        static String answer;
        static int maxLen;
        public String longestPalindrome(String s) {
            answer = "";
            maxLen = 0;
            for(int i = 0 ; i < s.length(); i++){
                findPal(i,i,s); // 문자 하나 -> 즉 홀수 문자열
                findPal(i,i+1,s); // 문자 두개 -> 즉 짝수 문자열
            }
            return answer;
        }

        // "좌 우" 가 같아야한다에 집중해야한다.
        // 문자 하나, 문자 두개의 케이스를 나누고자했을 때, 함수의 인자를 어떻게 뽑아낼 것인지 생각해보자

        static void findPal(int left, int right, String s){
            if (left < 0 || right >= s.length()){
                return;
            }
            if(s.charAt(left) == s.charAt(right)){
                if (maxLen < right - left + 1){
                    maxLen = right - left + 1;
                    answer = s.substring(left,right+1);
                }
                findPal(left-1,right+1,s);
            }
            else{
                return;
            }

        }
    }
}
