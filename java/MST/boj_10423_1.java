package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_10423_1 {
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        long cost;

        Edge(int start, int end, long cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Edge e){
            return (int) this.cost - (int) e.cost;
        }
    }
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i = 0; i <parent.length; i++){
            parent[i] = i;
        }
        // 발전소 (발전소의 부모 노드를 -1로 놓고, 모든 도시가 발전소의 노드를 부모로 할 수 있도록 한다)
        st = new StringTokenizer(br.readLine(), " ");
        for(int k = 0; k < K; k++){
            parent[Integer.parseInt(st.nextToken())] = -1;
        }

        // 도시 저장
        List<Edge> edges = new ArrayList<>();
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            edges.add(new Edge(start,end,cost));
        }
        Collections.sort(edges);

        long ans = 0;
        for(Edge e : edges){
            int n1 = e.start;
            int n2 = e.end;
            if(getParent(n1) == getParent(n2)) continue;
            union(n1,n2);
            ans += e.cost;
        }
        System.out.println(ans);
    }

    public static void union(int n1, int n2){
        int p1 = getParent(n1);
        int p2 = getParent(n2);

        if(p1 < p2){
            parent[p2] = p1;
        }
        else{
            parent[p1] = p2;
        }
    }
    public static int getParent(int n){
        if(parent[n] == n) return n;
        if(parent[n] == -1) return -1;
        return parent[n] = getParent(parent[n]);
    }
}
