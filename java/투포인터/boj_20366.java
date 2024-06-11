package 투포인터;
import java.io.*;
import java.util.*;
public class boj_20366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine(), "  ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < N-3; i++){
            for(int j = i+3; j < N; j++){
                int left = i+1;
                int right = j-1;
                while(left < right){
                    int sumA = arr[i]+arr[j];
                    int sumB = arr[left]+arr[right];
                    ans = Math.min(ans, Math.abs(sumA-sumB));
                    if(sumA > sumB){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
