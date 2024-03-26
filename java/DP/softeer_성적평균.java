package DP;
import java.io.*;
import java.util.*;

public class softeer_성적평균 {

    public class Main {

        public static void main(String[] args)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st =  new StringTokenizer(br.readLine(), " " );
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            double [] dp = new double[N+1];
            int[] score = new int[N+1];
            st = new StringTokenizer(br.readLine(), " ");
            for(int n = 1; n <= N ;n++){
                score[n] = Integer.parseInt(st.nextToken());
                if(n>1){
                    dp[n] = dp[n-1] + score[n];
                }
                else{
                    dp[n] = score[n];
                }
            }
            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                System.out.printf("%.2f\n", (dp[b]-dp[a-1])/(b-a+1));
            }
        }
    }

}
