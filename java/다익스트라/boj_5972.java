package 다익스트라;
import java.io.*;
import java.util.*;
public class boj_5972 {
    static class Edge {
        int next;
        int cost;
        Edge(int next, int cost){
            this.next = next;
            this.cost = cost;
        }
    }
    static int[] dist;
    static List<List<Edge>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(n1).add(new Edge(n2,cost));
            graph.get(n2).add(new Edge(n1,cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2)->e1.cost-e2.cost);
        pq.add(new Edge(1,0));
        dist[1] = 0;
        while(!pq.isEmpty()) {
            Edge curEdge = pq.poll();
            int curNode = curEdge.next;
            int cost = curEdge.cost;
            if(dist[curNode] < cost) continue;

            for(Edge e : graph.get(curNode)){
                int nextNode = e.next;
                int nextCost = cost + e.cost;
                if(dist[nextNode] > nextCost){
                    dist[nextNode] = nextCost;
                    pq.add(new Edge(nextNode,nextCost));
                }
            }
        }
        System.out.println(dist[N]);
    }
}
