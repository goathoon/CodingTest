package 이분탐색;
import java.util.*;
import java.io.*;
public class boj_10816_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            int x = Integer.parseInt(st.nextToken());
            int low = lower(x,arr);
            int high = upper(x,arr);
            sb.append(high-low).append(" ");
        }
        System.out.println(sb);
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
}
