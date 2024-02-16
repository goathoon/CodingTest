package 이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj_1654 {
    class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[] arr = new int[k];
            for(int i = 0; i < k; i++){
                arr[i] = sc.nextInt();
            }
            long l = 1, r = Integer.MAX_VALUE;
            while(l <= r){
                long mid = (l+r) / 2;
                int cut = 0;
                for(int e = 0; e < arr.length; e++){
                    cut += arr[e] / mid;
                }
                if (cut < n) r = mid-1;
                else l = mid+1;
            }
            System.out.println(r);
        }
    }
}
