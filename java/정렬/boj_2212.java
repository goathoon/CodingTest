package 정렬;

import java.io.*;
import java.util.*;

public class boj_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        List<Integer> diff = new ArrayList<>();
        for(int i = 0; i < N-1; i++){
            diff.add(arr[i+1]-arr[i]);
        }
        Collections.sort(diff,Comparator.reverseOrder());
        int ans = 0;
        for(int x = K-1; x < diff.size(); x++){
            ans += diff.get(x);
        }
        System.out.println(ans);
    }
}
