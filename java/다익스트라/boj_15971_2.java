package 다익스트라;
import java.io.*;
import java.util.*;
public class boj_15971_2 {
    static class Edge{
        int end;
        int dist;
        int maxDist = 0;
        Edge(int end, int dist){
            this.end = end;
            this.dist = dist;
        }
        Edge(int end, int dist, int maxDist){
            this.end = end;
            this.dist = dist;
            this.maxDist = maxDist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        List<List<Edge>> graph = new ArrayList<>();
        boolean[] visit = new boolean[N+1];
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Edge(e,dist));
            graph.get(e).add(new Edge(s,dist));
        }
        visit[r1] = true;
        Queue<Edge> q = new LinkedList<>();
        q.offer(new Edge(r1,0));
        while(!q.isEmpty()){
            Edge curE = q.poll();
            if(curE.end == r2){
                System.out.println(curE.dist - curE.maxDist);
                break;
            }
            for(Edge e : graph.get(curE.end)){
                int nextNum = e.end;
                int addDist = e.dist;
                if(visit[nextNum]) continue;
                q.offer(new Edge(nextNum,curE.dist + addDist, Math.max(curE.maxDist,addDist)));
                visit[nextNum] = true;
            }
        }
    }
}
