package 이분탐색;
import java.io.*;
import java.util.*;
public class boj_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans1 = 0;
        int ans2 = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int target = arr[i] * -1;
            int l = i+1, r = N-1;
            if(l>r) break;
            int find = binarySearch(l,r,target,arr);
            if(Math.abs(arr[i] + find) < Math.abs(result)){
                result = Math.abs(arr[i]+find);
                ans1 = arr[i];
                ans2 = find;
            }

        }
        if (ans1 > ans2) System.out.println(ans2 + " " + ans1);
        else System.out.println(ans1 + " " + ans2);

    }
    public static int binarySearch(int l, int r, int target, int[] arr){
        int min = Integer.MAX_VALUE;
        int answer = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if(Math.abs(target-arr[m]) < min){
                min = Math.abs(target-arr[m]);
                answer = arr[m];
            }
            if (target == arr[m]) {
                return answer;
            } else if (target < arr[m]) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return answer;
    }
}
