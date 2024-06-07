package 이분탐색;
import java.io.*;
import java.util.*;
public class boj_2805_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int ans = 0;
        int l = 0, r = 2_000_000_001;
        while(l <= r){
            int mid = (l+r)/2;
            long sum = 0;
            for(int tree: arr){
                if(tree - mid > 0){
                    sum += tree - mid;
                }
            }
            if(sum >= M){
                ans = Math.max(ans,mid);
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        System.out.println(ans);

    }
}
