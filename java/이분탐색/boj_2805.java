package 이분탐색;
import java.util.Scanner;
public class boj_2805 {

    class Main{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            long l = 0, r = Integer.MAX_VALUE;
            while(l <= r){
                long mid = (l+r) / 2;
                long cut = 0;
                for(int i = 0; i < arr.length; i++){
                    if(arr[i] > mid){
                        cut += arr[i] - mid;
                    }
                }
                if (cut < k) r = mid - 1;
                else l = mid + 1;
            }
            System.out.println(r);
        }
    }
}
