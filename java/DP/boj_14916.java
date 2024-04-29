package DP;
import java.io.*;
import java.util.*;
public class boj_14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.MAX_VALUE;
        }
        arr[0] = 0;
        for(int i = 2; i <= N; i++){
            if(i-2 >= 0 && arr[i-2] != Integer.MAX_VALUE){
                arr[i] = Math.min(arr[i-2]+1,arr[i]);
            }
            if(i-5 >= 0 && arr[i-5] != Integer.MAX_VALUE){
                arr[i] = Math.min(arr[i-5]+1,arr[i]);
            }
        }
        if(arr[N] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(arr[N]);
    }
}
