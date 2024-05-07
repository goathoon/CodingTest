package 이분탐색;
import java.util.*;
import java.io.*;
public class boj_10816_3 {
    public static void main(String[] args) throws IOException {
        boj_10816_3 bj = new boj_10816_3();
        SolutionWhenUpperBoundIsDifferent s = bj.new SolutionWhenUpperBoundIsDifferent();
        s.main();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[N];
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        for(int i = 0; i < N; i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(arr);
//
//        int M = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        st = new StringTokenizer(br.readLine(), " ");
//        for(int i = 0; i < M; i++){
//            int x = Integer.parseInt(st.nextToken());
//            int low = lower(x,arr);
//            int high = upper(x,arr);
//            sb.append(high-low).append(" ");
//        }
//        System.out.println(sb);
    }
    public static int lower(int x, int[] arr){
        int l = 0, r = arr.length;
        while(l < r){
            int mid = (l+r)/2;
            if (arr[mid] >= x){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    public static int upper(int x, int[] arr){
        int l = 0, r = arr.length;
        while(l < r){
            int mid = (l+r)/2;
            if(arr[mid] > x){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }

    // 만일 upper bound가 해당 값이 등장하는 마지막 위치일 경우
    public static int lastOf(int x, int[] arr){
        int l = 0, r = arr.length;
        while(l <= r){
            int mid = (l+r)/2;
            if(arr[mid] > x) {
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return r;
    }
    class SolutionWhenUpperBoundIsDifferent{
        public static void main() {
            int[] arr = new int[] {0, 1, 3, 5, 5, 5, 7, 9, 9, 10, 10, 12, 14};
            System.out.println(" last = " + lastOf(10,arr)); // 10이 나옴
        }
    }
}
