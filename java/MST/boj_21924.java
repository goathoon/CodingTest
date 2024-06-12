package MST;
import java.io.*;
import java.util.*;
public class boj_21924 {
    static class Edge{
        int start;
        int end;
        int cost;

        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    static class EdgeComparator implements Comparator<Edge>{
        public int compare(Edge e1, Edge e2){
            return e1.cost - e2.cost;
        }
    }
    static int[] parent;
    static Edge[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
        edges = new Edge[M];
        long sum = 0;
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[m] = new Edge(s,e,cost);
            sum += cost;
        }
        long ans = 0;
        Arrays.sort(edges, new EdgeComparator());
        for(Edge e : edges){
            if(getParent(e.start) == getParent(e.end)) continue;
            ans += e.cost;
            union(e.start,e.end);
        }
        for(int i = 2; i <= N ; i++){
            if(parent[i] == i) {
                System.out.println(-1);
                System.exit(0);
            }
        }
        System.out.println(sum-ans);

    }

    static void union(int a, int b){
        int pA = getParent(a);
        int pB = getParent(b);
        if(pA <= pB){
            parent[pB] = pA;
        }
        else{
            parent[pA] = pB;
        }
    }

    static int getParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }
}
