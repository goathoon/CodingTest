package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        long answer = 0;
        for(int i = 0; i < length; i++){
            int weight = Integer.parseInt(br.readLine());
            arr[i] = weight;
        }
        Arrays.sort(arr);
        for(int i = 0; i < length; i ++){
            answer = Math.max((long)arr[i] * (length - i), answer);
        }
        System.out.println(answer);
    }
}
