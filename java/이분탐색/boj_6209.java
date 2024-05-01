package 이분탐색;

import java.io.*;
import java.util.*;

public class boj_6209 {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int end = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        // 전체 징검다리 위치별로 정렬
        int[] stones = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            stones[i] = x;
        }
        stones[n] = end;
        Arrays.sort(stones);
        int ans = 0;
        int left = 0, right = end;
        while(left <= right){
            int mid = (left+right)/2;
            int steps = countNumbers(mid,stones);
            if(steps < n-m+1){
                right = mid-1;
            }else{
                ans = mid;
                left = mid+1;
            }
        }
        System.out.println(ans);
    }
    public static int countNumbers(int mid, int[] stones){
        int curPos = 0;
        int nextIdx = 0;
        int res = 0;
        while(nextIdx < stones.length){
            if(stones[nextIdx] - curPos >= mid){
                res++;
                curPos = stones[nextIdx];
            }
            nextIdx++;
        }
        return res;
    }
}
