package 벨만포드;
import java.io.*;
import java.util.*;
public class boj_11657_1 {
    static class Edge{
        int start;
        int end;
        int dist;
        Edge(int start, int end, int dist){
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();
        long[] dist = new long[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken()), dis = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start,end,dis));
        }
        dist[1] = 0;
        for(int i = 0; i < N; i++){
            boolean update = false;
            for(Edge e : edges){
                if(dist[e.start] == Integer.MAX_VALUE) continue;
                if(dist[e.end] <= dist[e.start] + e.dist) continue;
                dist[e.end] = dist[e.start] + e.dist;
                update = true;
            }
            if(i == N-1 && update){
                System.out.println(-1);
                System.exit(0);
            }
        }
        for(int i = 2; i <= N; i++){
            if(dist[i] != Integer.MAX_VALUE){
                System.out.println(dist[i]);
            }
            else{
                System.out.println(-1);
            }
        }
    }
}
