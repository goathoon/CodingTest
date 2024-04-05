package 다익스트라;

import java.io.*;
import java.util.*;
public class boj_9370 {
    static class Road{
        int end;
        int cost;
        Road(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }
    static List<List<Road>> graph;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < TC; tc ++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int g1 = Integer.parseInt(st.nextToken());
            int g2 = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int n = 0; n <= node; n++){
                graph.add(new ArrayList<>());
            }

            for(int r = 0; r < road; r++){
                st = new StringTokenizer(br.readLine(), " ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                graph.get(n1).add(new Road(n2,dist));
                graph.get(n2).add(new Road(n1,dist));
            }
            Set<Integer> goals = new HashSet<>();
            for(int g = 0; g < goal; g++){
                goals.add(Integer.parseInt(br.readLine()));
            }
            List<Integer> ans = new ArrayList<>();

            for(int g: goals){
                int res1 = dijkstra(start, g1) + dijkstra(g1, g2) + dijkstra(g2, g);
                int res2 = dijkstra(start, g2) + dijkstra(g2, g1) + dijkstra(g1, g);
                int res3 = dijkstra(start,g);

                int minRes = Math.min(res1,res2);
                if(minRes == res3){
                    ans.add(g);
                }
            }


            Collections.sort(ans);
            StringBuilder sb = new StringBuilder();
            for(int a : ans){
                sb.append(a).append(" ");
            }
            System.out.println(sb);
            graph.clear();
        }
    }
    public static int dijkstra(int start, int end){
        class Pos{
            int num;
            int dist;
            Pos(int num, int dist){
                this.num = num;
                this.dist = dist;
            }
        }
        int[] dist = new int[graph.size()+1];
        for(int i = 0; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pos> pq = new PriorityQueue<>((p1,p2)->p1.dist-p2.dist);
        dist[start] = 0;
        pq.add(new Pos(start, 0));
        while(!pq.isEmpty()){
            Pos curP = pq.poll();
            int curNum = curP.num;
            int curDist = curP.dist;
            if(curNum == end){
                return dist[curNum];
            }
            if(curDist > dist[curNum]) continue;

            for(Road r : graph.get(curNum)){
                int next = r.end;
                int nextDist = curP.dist + r.cost;
                if(dist[next] > nextDist){
                    dist[next] = nextDist;
                    pq.add(new Pos(next,nextDist));
                }
            }
        }
        return -1;
    }
}
