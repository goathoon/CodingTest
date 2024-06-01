package 벨만포드;
import java.io.*;
import java.util.*;
public class boj_11657 {
    static class Edge{
        int start;
        int end;
        int cost;
        Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        List<Edge> graph = new ArrayList<>();
        long[] dist = new long[N+1];

        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken()), cost = Integer.parseInt(st.nextToken());
            graph.add(new Edge(start,end,cost));
        }

        //1번 노드 출발
        dist[1] = 0;

        for(int n = 1; n <= N; n++){
            boolean update = false;
            for(Edge e : graph){
                if(dist[e.start] != Integer.MAX_VALUE && dist[e.end] > dist[e.start] + e.cost){
                    dist[e.end] = dist[e.start] + e.cost;
                    update = true;
                }
            }
            if(n == N && update){
                System.out.println(-1);
                System.exit(0);
            }
        }
        for(int i = 2; i <= N; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println(-1);
            }
            else{
                System.out.println(dist[i]);
            }
        }
    }
}
