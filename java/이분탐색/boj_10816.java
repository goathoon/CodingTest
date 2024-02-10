package 이분탐색;
import java.io.*;
import java.util.*;
public class boj_10816 {
    /** Thanks to Blog
     *  https://st-lab.tistory.com/267
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n == arr[arr.length-1]){
                sb.append(upperBound(n,arr) - lowerBound(n,arr) + 1 + " ");
                continue;
            }
            sb.append(upperBound(n,arr) - lowerBound(n,arr) + " ");
        }
        System.out.println(sb);
    }
    public static int lowerBound(int target, int[] arr){
        int l = 0, r = arr.length-1;
        while(l < r){
            int m = (l + r) / 2;
            if(arr[m] >= target){
                r = m;
            }
            else{
                l = m+1;
            }
        }
        return (l+r)/2;
    }
    public static int upperBound(int target, int[] arr){
        int l = 0, r = arr.length-1;
        while(l < r){
            int m = (l + r) / 2;
            if(arr[m] > target){
                r = m;
            }
            else{
                l = m+1;
            }
        }
        return (l+r)/2;
    }

}
