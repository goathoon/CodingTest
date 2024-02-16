package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2110 {
    class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            long l = 1, r = 1_000_000_000;
            while(l <= r){
                long min = (l+r) / 2;
                int prev = arr[0];
                int cnt = 1;
                for(int i = 1; i < arr.length; i++){
                    if(arr[i] >= prev + min){
                        cnt ++;
                        prev = arr[i];
                    }
                }

                if(cnt >= k){
                    l = min + 1;
                }
                else r = min - 1;
            }
            System.out.println(r);
        }
    }
}
