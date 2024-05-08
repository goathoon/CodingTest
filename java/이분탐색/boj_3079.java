package 이분탐색;

import java.io.*;
import java.util.*;

public class boj_3079 {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[] arr = new long[(int)N];
        for(int n = 0; n < N; n++){
            long t = Long.parseLong(br.readLine());
            arr[n] = t;
        }
        long r = (long) Math.pow(10,18);
        long l = 0;
        while(l < r){
            long mid = (l+r)/2;
            long cnt = 0;
            for(int n = 0; n < N; n++){
                cnt += mid/arr[n];
                if(cnt > M) break;
            }
            if(cnt < M){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        System.out.println(l);
    }
}
