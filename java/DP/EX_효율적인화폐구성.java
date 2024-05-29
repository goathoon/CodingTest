package DP;
import java.io.*;
import java.util.*;
public class EX_효율적인화폐구성 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), target = Integer.parseInt(st.nextToken());
        int[] arr = new int[target+1];
        int[] coin = new int[N];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[0] = 0;

        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 1; i <= target; i++){
            for(int c : coin){
                if(i-c >= 0 && arr[i-c] != Integer.MAX_VALUE){
                    arr[i] = Math.min(arr[i-c]+1, arr[i]);
                }
            }
        }
        if(arr[target] == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(arr[target]);
        }
    }
}
