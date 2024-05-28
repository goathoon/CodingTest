package 이분탐색;
import java.io.*;
import java.util.*;
public class EX_정렬된배열에서특정수의개수구하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int lower = lowerBound(target,arr);
        int upper = upperBound(target,arr);
        System.out.println(upper-lower);

    }

    public static int lowerBound(int target, int[] arr){
        int s = 0, e = arr.length;
        while(s < e){
            int mid = (s+e)/2;
            if(arr[mid] >= target){
                e = mid;
            }else{
                s = mid+1;
            }
        }
        return s;
    }
    public static int upperBound(int target, int[] arr){
        int s = 0, e = arr.length;
        while(s < e){
            int mid = (s+e)/2;
            if(arr[mid] <= target){
                s = mid+1;
            }else{
                e = mid;
            }
        }
        return s;
    }
}
