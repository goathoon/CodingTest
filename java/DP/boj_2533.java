package DP;

import java.io.*;
import java.util.*;
public class boj_2533 {
    static List<List<Integer>> tree;
    static int[][] dp;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for(int i = 0 ; i <= N; i++){
            tree.add(new ArrayList<>());
        }
        dp = new int[N+1][2];
        visit = new boolean[N+1];
        for(int n = 0; n < N-1; n++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree.get(s).add(e);
            tree.get(e).add(s);
        }
        dfs(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }
    public static void dfs(int s){
        dp[s][0] = 0;
        dp[s][1] = 1; // 자기 자신이 얼리어답터인경우
        visit[s] = true;
        for (int next : tree.get(s)){
            if(!visit[next]){
                dfs(next);
                dp[s][0] += dp[next][1];
                dp[s][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }

    }
}
