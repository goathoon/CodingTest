package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1922 {
    public static void main(String[] args) throws IOException {
        class Edge implements Comparable<Edge> {
            int end;
            long cost;
            Edge(int end, long cost){
                this.end = end;
                this.cost = cost;
            }
            public int compareTo(Edge e2){
                return (int)(this.cost - e2.cost);
            }

        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        boolean[] visited = new boolean[N+1];
        List<List<Edge>> graph = new ArrayList<>();
        for(int m = 0; m < N+1; m++) {
            graph.add(new ArrayList<Edge>());
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end,cost));
            graph.get(end).add(new Edge(start,cost));
        }
        long answer = 0;
        pq.add(new Edge(1,0L));
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int curNode = cur.end;
            long curCost = cur.cost;
            if(visited[curNode]) continue;
            visited[curNode] = true;
            answer += curCost;
            for(Edge e : graph.get(curNode)){
                pq.add(new Edge(e.end,e.cost));
            }
        }
        System.out.println(answer);
    }
}
