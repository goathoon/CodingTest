package 구간합;
import java.io.*;
import java.util.*;
public class boj_19951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+2];
        int[] sum = new int[N+2];

        st = new StringTokenizer(br.readLine(), " ");
        for(int n = 1; n <= N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            sum[s] += val;
            sum[e+1] -= val;
        }

        for(int n = 1; n <= N; n++){
            sum[n] += sum[n-1];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int n = 1; n <= N; n++){
            bw.write(arr[n] + sum[n] + " ");
        }

        bw.flush();
        bw.close();
    }
}
