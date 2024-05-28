package 이분탐색;

import java.io.*;
import java.util.*;

public class boj_2805_1 {
    class 답을탐색마다갱신 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            long ans = 0;
            long start = 0;
            long end = 1_000_000_000;
            while (start <= end) {
                long mid = (start + end) / 2;
                long sum = 0;
                for (int x : arr) {
                    if (x - mid > 0) sum += x - mid;
                }
                if (sum >= M) {
                    start = mid + 1;
                    ans = mid;
                } else {
                    end = mid - 1;
                }
            }
            System.out.println(ans);
        }
    }
    class MySol {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            long start = 0;
            long end = 1_000_000_000;
            while (start <= end) {
                long mid = (start + end) / 2;
                long sum = 0;
                for (int x : arr) {
                    if (x - mid > 0) sum += x - mid;
                }
                if (sum >= M) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            System.out.println(end);
        }
    }
}
