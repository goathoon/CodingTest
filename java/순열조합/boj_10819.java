package 순열조합;
import java.io.*;
import java.util.*;
public class boj_10819 {
    static boolean[] visit;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        visit = new boolean[N];
        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        dfs(0,N, 0,0);
        System.out.println(answer);
    }

    public static void dfs(int depth, int max, int cur, int ans){
        if(depth == max){
            answer = Math.max(answer,ans);
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(visit[i]) continue;
            visit[i] = true;
            if(depth == 0){
                dfs(1,max,arr[i],ans);
            }
            else{
                dfs(depth+1,max, arr[i], ans + Math.abs(cur-arr[i]));
            }
            visit[i] = false;
        }
    }
}
