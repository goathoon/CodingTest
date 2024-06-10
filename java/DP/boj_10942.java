package DP;
import java.io.*;
import java.util.*;
public class boj_10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[N+1][N+1];
        for(int i = 1; i <= N; i++){
            dp[i][i] = true;
        }
        for(int add = 1; add <= N-1; add++){
            for(int i = 1; i+add <= N; i++){
                if(add == 1){
                    if(arr[i] == arr[i+add]){
                        dp[i][i+add] = true;
                    }
                    continue;
                }
                if(dp[i+1][i+add-1] && arr[i] == arr[i+add]){
                    dp[i][i+add] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
            if(dp[start][end]){
                bw.write('1');
            }
            else{
                bw.write('0');
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
