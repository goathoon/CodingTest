package DP;
import java.io.*;
import java.util.*;
public class boj_2011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] dp = new int[s.length()];

        if(s.length() == 0 || s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        final int mod = 1000000;

        dp[0] = 1;


        if(s.length() >= 2){
            boolean pass = false;
            if(s.charAt(1) != '0') {
                dp[1] += dp[0];
                pass = true;
            }
            if(checkBound(s.substring(0,2))){
                dp[1] += 1;
                pass = true;
            }
            if(!pass) {
                System.out.println(0);
                return;
            }
        }

        // 123 을 예시로
        // ABC (1,2,3 정직하게)
        // LC (12,3)
        // AW (1,23)
        // 총 세가지

        // 0을 조심할것
        for(int idx = 2; idx < s.length(); idx++){
            boolean pass = false;

            if(s.charAt(idx) != '0') {
                dp[idx] += dp[idx-1];
                pass = true;
                dp[idx] %= mod;
            }

            if(checkBound(s.substring(idx-1,idx+1))){
                dp[idx] += dp[idx-2];
                pass = true;
                dp[idx] %= mod;
            }

            if(!pass){
                System.out.println(0);
                return;
            }
        }
        System.out.println(dp[s.length()-1]);
    }

    public static boolean checkBound(String s){
        int tenth = s.charAt(0) - '0';
        int last = s.charAt(1) - '0';
        if(tenth == 0 || tenth >= 3) return false;
        if(1 == tenth) return true;
        if(tenth == 2 && last <= 6) return true;

        return false;
    }
}
