package 이분탐색;

import java.io.*;
import java.util.*;
public class boj_2467 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        for(int i = 0; i < N-1; i++){
            int now = arr[i];

            int findIdx = binSearch(i+1, N-1, now*-1, arr);
            if(Math.abs(now+arr[findIdx]) < res){
                res = Math.abs(now+arr[findIdx]);
                left = now;
                right = arr[findIdx];
            }
            if(i != findIdx-1){
                if(Math.abs(now+arr[findIdx-1]) < res){
                    res = Math.abs(now+arr[findIdx-1]);
                    left = now;
                    right = arr[findIdx-1];
                }
            }

        }
        System.out.printf("%d %d", left,right);
    }
    public static int binSearch(int l, int r, int target, int[] arr){
        while(l < r){
            int mid = (l+r)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        if(l >= arr.length){
            l = arr.length-1;
        }
        return l;
    }
}
