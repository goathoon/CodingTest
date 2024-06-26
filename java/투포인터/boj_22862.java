package 투포인터;
import java.io.*;
import java.util.*;
public class boj_22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0;
        int cnt = 0;
        int ans = 0;
        while(r < N){
            // 짝수이면 r 추가 해서 길이 늘림
            if(arr[r] % 2 == 0){
                ans = Math.max(ans,r-l+1-cnt);
            }
            // 홀수이면 제거해야할 숫자가 증가. 만약 제거숫자가 K보다 크다면 l을 추가시켜야함
            else{
                ans = Math.max(ans,r-l-cnt);
                cnt++;
                while(cnt > K){
                    if(arr[l] % 2 != 0){
                        cnt--;
                    }
                    l++;
                }
            }
            r++;
        }
        System.out.println(ans);
    }
}
