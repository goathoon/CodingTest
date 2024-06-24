package MST;
import java.io.*;
import java.util.*;
public class boj_10423 {
    static class Edge implements Comparable<Edge>{
        int next;
        long cost;

        Edge(int next, long cost) {
            this.next = next;
            this.cost = cost;
        }

        public int compareTo(Edge e){
            return (int) this.cost - (int) e.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[N+1];
        List<List<Edge>> graph = new ArrayList<>();
        for(int n = 0; n <= N; n++){
            graph.add(new ArrayList<>());
        }

        // 발전소 저장
        st = new StringTokenizer(br.readLine(), " ");
        int[] electronics = new int[K];
        for(int k = 0; k < K; k++){
            electronics[k] = Integer.parseInt(st.nextToken());
        }

        // 도시 별 연결 상태 저장
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            graph.get(n1).add(new Edge(n2,cost));
            graph.get(n2).add(new Edge(n1,cost));
        }

        // 각 발전소 별로 프림 알고리즘 적용
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int e : electronics){
            visit[e] = true;
            for(Edge edge : graph.get(e)){
                pq.offer(edge);
            }
        }

        long ans = 0;
        // pq에서 하나씩 빼면서 추가
        while(!pq.isEmpty()){
            Edge curEdge = pq.poll();
            if(visit[curEdge.next]) continue;

            visit[curEdge.next] = true;
            ans += curEdge.cost;
            for(Edge nextE : graph.get(curEdge.next)){
                if(visit[nextE.next]) continue;
                pq.offer(nextE);
            }
        }

        System.out.println(ans);
    }
}
