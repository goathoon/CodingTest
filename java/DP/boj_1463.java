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
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.MAX_VALUE;
            }
            dfs(N, 0);
            System.out.println(arr[1]);
        }

        public static void dfs(int N, int val) {
            if (arr[N] <= val) {
                return;
            }
            arr[N] = val;
            if (N == 1) {
                return;
            }
            if (N % 3 == 0) {
                dfs(N / 3, val + 1);
            }
            if (N % 2 == 0) {
                dfs(N / 2, val + 1);
            }
            dfs(N - 1, val + 1);
        }
    }
}
