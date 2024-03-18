package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_13023 {
    static List<List<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        graph = new ArrayList<>();
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }
        for(int l = 0; l < line; l++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            graph.get(r1).add(r2);
            graph.get(r2).add(r1);
        }
        for(int i = 0; i < N-1; i++){
            if(dfs(i) >= 5){
                System.out.println(1);
                return;
            }
            visited[i] = false;
        }
        System.out.println(0);
    }
    public static int dfs(int curN){
        int ans = 1;
        int add = 0;
        visited[curN] = true;
        for(int nextN : graph.get(curN)){
            if(!visited[nextN]){
                add = Math.max(add,dfs(nextN));
                if(add >= 4){
                    return 5;
                }
                visited[nextN] = false;
            }

        }
        return ans + add;
    }

}
