package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int c1 = 1; c1 < s1.length()+1; c1++){
            for(int c2 = 1; c2 < s2.length()+1; c2++){
                if(s1.charAt(c1-1) == s2.charAt(c2-1)){
                    dp[c1][c2] = dp[c1-1][c2-1] + 1;
                }
                else{
                    dp[c1][c2] = Math.max(dp[c1-1][c2],dp[c1][c2-1]);
                }
            }
        }
        int startR = s1.length();
        int startC = s2.length();
        Stack<Character> stack = new Stack<>();
        while(true){
            if(s1.charAt(startR-1) == s2.charAt(startC-1)){
                stack.add(s1.charAt(startR-1));
                startR--;
                startC--;
            }
            else{
                if(startR-1 >= 0 && startC-1 >= 0){
                    if(dp[startR-1][startC] > dp[startR][startC-1]) {
                        startR--;
                    }else{
                        startC--;
                    }
                }
            }
            if(dp[startR][startC] == 0){
                break;
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
        while(!stack.isEmpty()){
            System.out.printf("%c",stack.pop());
        }
    }
}
