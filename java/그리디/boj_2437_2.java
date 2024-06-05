package 그리디;
import java.io.*;
import java.util.*;
public class boj_2437_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        int r = 0;
        for(int i = 0; i < N; i++){
            if(arr[i] <= r+1){
                r += arr[i];
            }else{
                break;
            }
        }
        System.out.println(r+1);
    }
}
