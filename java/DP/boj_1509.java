package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // dp배열은 i번째 문자열까지 최소 palindrome 쌍의 개수
        int[] dp = new int[s.length()+1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        boolean[][] palindrome = new boolean[s.length()+1][s.length()+1];

        checkPal(palindrome,s);

        // 만일 palindrome[start][end] 가 true이면
        // dp[end] = dp[start-1] + 1로 하면 됩니다.

        for(int start = 1; start < dp.length; start++){
            for(int end = start; end < dp.length; end++){
                if(palindrome[start][end]){
                    dp[end] = Math.min(dp[start-1] + 1, dp[end]);
                }
            }
        }
        System.out.println(dp[s.length()]);
    }

    public static void checkPal(boolean[][] palindrome, String str){
        for(int start = 1; start < str.length()+1; start++){
            for(int end = start; end < str.length()+1; end++){
                boolean isPal = true;
                int s = start-1;
                int e = end-1;
                while(s <= e) {
                    if (str.charAt(s) != str.charAt(e)) {
                        isPal = false;
                        break;
                    }
                    s++;
                    e--;
                }
                palindrome[start][end] = isPal;
            }
        }
    }
}
