package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0, r = 0;
        long sum = arr[0];
        int ans = Integer.MAX_VALUE;
        boolean possible = false;
        while(true){
            if(S <= sum){
                possible = true;
                if(l==r){
                    System.out.println(1);
                    return;
                }
                ans = Math.min(ans,r-l+1);
                sum -= arr[l];
                l++;
            }
            else{
                r++;
                if(r == N){
                    if(possible){
                        System.out.println(ans);
                        return;
                    }
                    else{
                        System.out.println(0);
                        return;
                    }
                }
                sum += arr[r];
            }
        }
    }
}
