package 그리디;

import java.io.*;
import java.util.*;
public class boj_2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int checkNum = 1;
        for(int i = 0; i < arr.length; i++){
            if(checkNum < arr[i]){
                break;
            }
            checkNum += arr[i];
        }
        System.out.println(checkNum);

        // 1 1 2 3 6 7 30
        //
    }
}
