package 이분탐색;
import java.io.*;
import java.util.*;
public class boj_1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        boolean[] arr = new boolean[L+1];
        for(int i = 0; i < N; i++){
            arr[Integer.parseInt(st.nextToken())] = true;
        }

        int l = 1, r = L-1;
        // 최대 길이 (cnt가 M개의 세울 도시의 수가 같을때 길이를 늘여가면서 체크하자)
        while(l < r){
            int cnt = 0;
            int mid = (l+r) / 2;
            int before = 0;
            for(int i = 1; i < L; i++){
                if(arr[i]){
                    before = i;
                    continue;
                }
                if(mid == i - before){
                    cnt++;
                    before = i;
                }
            }
            if(cnt > M){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        System.out.println(l);
    }
}