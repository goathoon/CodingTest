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
    static boolean[] visit;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < TC; tc ++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());
            visit = new boolean[node+1];

            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int g1 = Integer.parseInt(st.nextToken());
            int g2 = Integer.parseInt(st.nextToken());

            // 반드시 거치는 곳
            Set<Integer> needs = new HashSet<>();
            needs.add(g1);
            needs.add(g2);

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

            // 반드시 거쳐야하는 경로의 끝지점을 다익스트라로 찾고 newStart로 지정
            // 이 때, 거쳐가는 모든 Node들을 visit처리함. 해당 경로들은 무조건 최종 목적지 까지 가는데에 지장이 없기 때문임.
            int newStart = dijkstraToNeed(start,needs);

            List<Integer> ans = dijkstra(newStart,goals);
            Collections.sort(ans);
            StringBuilder sb = new StringBuilder();
            for(int a : ans){
                sb.append(a).append(" ");
            }
            System.out.println(sb);
            graph.clear();
        }
    }

    public static int dijkstraToNeed(int start, Set<Integer> needs){
        class Pos{
            int end;
            int cost;
            Pos(int end, int cost){
                this.end = end;
                this.cost = cost;
            }
        }
        int[] dist = new int[graph.size() + 1];
        for(int i = 0; i <dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        PriorityQueue<Pos> pq = new PriorityQueue<>((p1,p2)->p1.cost-p2.cost);
        pq.add(new Pos(start, 0));

        boolean isEnd = false;
        while(!pq.isEmpty()){
            Pos curP = pq.poll();
            int curNum = curP.end;
            int curCost = curP.cost;
            if(dist[curNum] < curCost) continue;


            if(isEnd && needs.contains(curNum)){
                return curNum;
            }
            visit[curNum] = true;
            if(needs.contains(curNum)) isEnd = true;

            for(Road r : graph.get(curNum)){
                if(r.cost+curCost < dist[r.end]){
                    dist[r.end] = r.cost+curCost;
                    pq.add(new Pos(r.end, r.cost + curCost));
                }
            }
        }
        return -1;
    }

    public static List<Integer> dijkstra(int start, Set<Integer> goals){
        class Pos {
            int num;
            int cost;
            Pos(int num, int cost){
                this.num = num;
                this.cost = cost;
            }
        }
        List<Integer> answers = new ArrayList<>();

        int[] dist = new int[graph.size()+1];
        for(int i = 0; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Pos> pq = new PriorityQueue<>((p1,p2)->p1.cost-p2.cost);
        pq.add(new Pos(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Pos curP = pq.poll();
            int curNum = curP.num;
            int curCost = curP.cost;
            if(dist[curNum] < curCost) continue;
//            if(goals.contains(curNum)) break;

            for(Road r : graph.get(curNum)){
                if(visit[r.end] || curCost + r.cost >= dist[r.end]) continue;
                pq.add(new Pos(r.end, curCost + r.cost));
                dist[r.end] = curCost + r.cost;
            }
        }
        for(int g : goals){
            if(dist[g] != Integer.MAX_VALUE && !visit[g]){
                answers.add(g);
            }
        }
        return answers;

    }
}
