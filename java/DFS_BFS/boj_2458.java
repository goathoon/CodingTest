package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2458 {
    static boolean[][] visit;
    static List<List<Integer>> list;
    static List<List<Integer>> reversedList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1][N+1];
        list = new ArrayList<>();
        reversedList = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
            reversedList.add(new ArrayList<>());
        }
        for(int c = 0; c < cnt; c++){
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list.get(n1).add(n2);
            reversedList.get(n2).add(n1);
        }
        for(int i = 1; i <= N; i++){
            dfs(i,i);
            reverseDfs(i,i);
        }
        int ans = 0;
        Loop : for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if (!visit[i][j]) continue Loop;
            }
            ans++;
        }
        System.out.println(ans);
    }
    public static void dfs(int root,int num){
        visit[root][num] = true;
        for(int next : list.get(num)){
            if(!visit[root][next]){
                dfs(root,next);
            }
        }
    }
    public static void reverseDfs(int root, int num){
        visit[root][num] = true;
        for(int next : reversedList.get(num)){
            if(!visit[root][next]){
                reverseDfs(root,next);
            }
        }
    }

}
