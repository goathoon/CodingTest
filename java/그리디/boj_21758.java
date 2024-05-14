package 그리디;

import java.io.*;
import java.util.*;

public class boj_21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int n = 1; n <= N; n++){
            arr[n] += arr[n-1] + Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        // 벌 벌 통, 통 벌 벌
        for(int i = 2; i < N; i++){
            ans = Math.max(ans,(arr[i-1]-arr[1])+(arr[N]-arr[i])*2);
        }
        // 벌 통 벌
        for(int i = 2; i < N; i++){
            ans = Math.max(ans, arr[i]-arr[1] + arr[N-1]-arr[i] + arr[i]-arr[i-1]);
        }
        //통 벌 벌
        for(int i = 2; i < N; i++){
            ans = Math.max(ans,(arr[i-1]-arr[0])*2 + arr[N-1]-arr[i]);
        }

        System.out.println(ans);
    }
}
