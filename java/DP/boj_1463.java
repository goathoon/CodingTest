package DP;
import java.io.*;
import java.util.*;
public class boj_1463 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N + 1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[1] = 0;
        for (int i = 2; i <= N; i++) {
            arr[i] = Math.min(arr[i - 1] + 1, arr[i]);
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
            }
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
            }
        }
        System.out.println(arr[N]);
    }
    class TopDown {
        static int[] arr;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            arr = new int[N + 1];
            Arrays.fill(arr,Integer.MAX_VALUE);
            System.out.println(dfs(N));
        }

        // N의 수를 1로 만들기 위해 필요한 계산 수 반환
        public static int dfs(int N) {
            if(N==1){
                return 0;
            }
            if(arr[N] == Integer.MAX_VALUE){
                if(N % 3 == 0){
                    arr[N] = Math.min(dfs(N/3)+1, arr[N]);
                }
                if(N % 2 == 0){
                    arr[N] = Math.min(dfs(N/2)+1, arr[N]);
                }
                arr[N] = Math.min(dfs(N-1)+1, arr[N]);
            }
            return arr[N];
        }
    }
}
