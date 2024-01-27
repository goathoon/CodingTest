package DP;

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

}
