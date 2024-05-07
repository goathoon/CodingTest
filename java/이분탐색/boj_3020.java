package 이분탐색;

import java.io.*;
import java.util.*;
public class boj_3020 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] up = new int[N/2];
        int[] down = new int[N/2];
        for(int n = 0; n < N; n++){
            int h = Integer.parseInt(br.readLine());
            if (n%2==0) up[n/2] = h;
            else down[n/2] = h;
        }
        Arrays.sort(up);
        Arrays.sort(down);

        // h-1 ~ h 높이에서 자름
        int ans = Integer.MAX_VALUE;
        int count = 0;
        for(int h = 1; h <= H; h++){
            // up 기준으로, h보다 크거나 같은 최초의 index
            int upIdx = getLowerBound(up,h);
            // down 기준으로 H-h+1 보다 같거나 큰 최초의 index
            int downIdx = getLowerBound(down,H-h+1);
            int sum = up.length-upIdx + down.length-downIdx;
            if(ans == sum){
                count++;
            }
            else if (ans > sum){
                ans = sum;
                count = 1;
            }
        }
        System.out.println(ans + " " + count);
    }
    public static int getLowerBound(int[] arr, int h){
        // arr.length 잘볼 것
        int l = 0, r = arr.length;
        while(l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    class Solution2{
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int[] up = new int[N/2];
            int[] down = new int[N/2];
            for(int n = 0; n < N; n++){
                int h = Integer.parseInt(br.readLine());
                if (n%2==0) up[n/2] = h;
                else down[n/2] = h;
            }
            Arrays.sort(up);
            Arrays.sort(down);

            // h-1 ~ h 높이에서 자름
            int ans = Integer.MAX_VALUE;
            int count = 0;
            for(int h = 1; h <= H; h++){
                // up 기준으로, h보다 크거나 같은 최초의 index
                int upIdx = getLowerBound(up,h);
                // down 기준으로 H-h+1 보다 같거나 큰 최초의 index
                int downIdx = getLowerBound(down,H-h+1);
                int sum = up.length-upIdx + down.length-downIdx;
                if(ans == sum){
                    count++;
                }
                else if (ans > sum){
                    ans = sum;
                    count = 1;
                }
            }
            System.out.println(ans + " " + count);
        }
        public static int getLowerBound(int[] arr, int h){
            int l = 0, r = arr.length-1;
            while(l <= r) {
                int mid = (l + r) / 2;
                if (arr[mid] < h) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }
}
