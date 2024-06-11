package DP;

import java.io.*;
import java.util.StringTokenizer;

public class boj_9177 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            String concat = st.nextToken();
            boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
            dp[0][0] = true;
            for(int c = 1; c < dp[0].length; c++){
                if(concat.charAt(c-1) == s2.charAt(c-1)) {
                    dp[0][c] = true;
                }
                else break;
            }
            for(int r = 1; r < dp.length; r++){
                if(concat.charAt(r-1) == s1.charAt(r-1)) {
                    dp[r][0] = true;
                }
                else break;
            }

            for(int r = 1; r < dp.length; r++){
                for(int c = 1; c < dp[0].length; c++){
                    char c1 = s1.charAt(r-1), c2 = s2.charAt(c-1), e = concat.charAt(r+c-1);
                    if(c1 != e && c2 != e) continue;
                    if(c1 == e && dp[r-1][c]) dp[r][c] = true;
                    if(c2 == e && dp[r][c-1]) dp[r][c] = true;
                }
            }
            bw.write("Data set " + i +": ");
            if(dp[s1.length()][s2.length()]){
                bw.write("yes");
            }
            else{
                bw.write("no");
            }
            bw.newLine();

        }
        bw.flush();
        bw.close();
    }
}
