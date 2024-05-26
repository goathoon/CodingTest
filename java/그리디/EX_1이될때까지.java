package 그리디;
import java.io.*;
import java.util.*;
public class EX_1이될때까지 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int ans = 0;
        while(N != 1){
            if(N % K == 0){
                N = N/K;
            }else{
                N -= 1;
            }
            ans++;
        }
        System.out.println(ans);
    }
}
