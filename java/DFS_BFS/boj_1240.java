package DFS_BFS;
import java.io.*;
import java.util.*;
public class boj_1240 {
    static List<List<int[]>> tree;
    static int ans = 0;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tree = new ArrayList<>();
        visit = new boolean[N+1];
        for(int n = 0; n <= N; n++){
            tree.add(new ArrayList<>());
        }
        for(int n = 1; n < N; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            tree.get(n1).add(new int[]{n2,dist});
            tree.get(n2).add(new int[]{n1,dist});
        }
        for(int m = 1; m <= M; m++){
            ans = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            dfs(n1,n2,0);
            System.out.println(ans);
            for(int i =0 ; i < visit.length; i++){
                visit[i] = false;
            }
        }
    }
    public static void dfs(int n1, int n2, int dist){
        if(n1 == n2){
            ans = dist;
            return;
        }
        visit[n1] = true;
        for(int[] next : tree.get(n1)){
            if(visit[next[0]]) continue;
            dfs(next[0],n2,dist+next[1]);
        }
    }
    class BeforeSolution{
        static List<List<int[]>> tree;
        static boolean[] visit;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            tree = new ArrayList<>();
            visit = new boolean[N+1];
            for(int n = 0; n <= N; n++){
                tree.add(new ArrayList<>());
            }
            for(int n = 1; n < N; n++) {
                st = new StringTokenizer(br.readLine(), " ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                tree.get(n1).add(new int[]{n2,dist});
                tree.get(n2).add(new int[]{n1,dist});
            }
            for(int m = 1; m <= M; m++){
                st = new StringTokenizer(br.readLine(), " ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                System.out.println(dfs(n1,n2,0));
                for(int i =0 ; i < visit.length; i++){
                    visit[i] = false;
                }
            }
        }
        public static int dfs(int n1, int n2, int dist){
            visit[n1] = true;
            int ans = 0;
            for(int[] next : tree.get(n1)){
                if(visit[next[0]]) continue;
                if(next[0] != n2){
                    ans = dfs(next[0],n2,dist+next[1]);
                    if(ans != 0){
                        return ans;
                    }
                }
                else{
                    return dist+next[1];
                }
            }
            return ans;
        }
    }
}
