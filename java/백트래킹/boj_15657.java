package 백트래킹;

import java.io.*;
import java.util.*;


public class boj_15657 {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0,0,M,new int[M]);
    }
    public static void dfs(int curIdx, int depth, int len, int[] ans) {
        if(depth == len){
            StringBuilder sb = new StringBuilder();
            for(int x : ans){
                sb.append(x).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int idx = curIdx; idx < arr.length; idx++){
            ans[depth] = arr[idx];
            dfs(idx,depth+1,len,ans);
        }

    }
}
