package 이분탐색;
import java.io.*;
import java.util.*;
public class boj_12015 {
        // 1 2 3 4
        // 1 2 4 5 8
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            int l = 0, r = list.size() - 1;
            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            } else {
                int m = (l + r) / 2;
                while (l < r) {
                    if (list.get(m) >= arr[i]) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                    m = (l + r) / 2;
                }
                if(list.get(m) >= arr[i]) list.set(m, arr[i]);
            }
        }
        System.out.println(list.size());
    }
}
