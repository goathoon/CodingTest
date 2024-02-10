package DP;

public class leet_647 {
    class Solution {
        public int countSubstrings(String s) {
            int totalLen = s.length();
            boolean[][] isPal = new boolean[totalLen][totalLen];
            // substring의 길이가 1과 2인경우의 palindrome여부를 미리 저장
            for(int i = 0; i < totalLen-1; i++){
                isPal[i][i] = true;
                if(s.charAt(i) == s.charAt(i+1)) {
                    isPal[i][i+1] = true;
                }
            }
            isPal[totalLen-1][totalLen-1] = true;

            for(int strLen = 3; strLen <= totalLen; strLen++ ){
                int plusIndex = strLen-1;
                for(int i = 0; i <= totalLen-strLen; i++){
                    if(isPal[i+1][i+plusIndex-1] && s.charAt(i) == s.charAt(i+plusIndex)){
                        isPal[i][i+plusIndex] = true;
                    }
                }
            }
            int ans = 0;
            for(int i = 0; i < totalLen; i++){
                for(int j = 0; j < totalLen; j++){
                    if(isPal[i][j]) ans++;
                }
            }
            return ans;
        }
    }
}
