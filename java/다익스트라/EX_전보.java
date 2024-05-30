package 다익스트라;

import java.io.*;
import java.util.*;

public class EX_전보 {
    static class Pos{
        int num;
        int cost;
        Pos(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        List<List<Pos>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken()), Z = Integer.parseInt(st.nextToken());
            graph.get(X).add(new Pos(Y,Z));
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[C] = 0;
        PriorityQueue<Pos> pq = new PriorityQueue<>((p1,p2)->p1.cost-p2.cost);
        pq.offer(new Pos(C,0));

        while(!pq.isEmpty()){
            Pos p = pq.poll();
            int curCost = p.cost;
            int curNum = p.num;
            if(dist[curNum] < curCost) continue;
            for(Pos next : graph.get(curNum)){
                if(dist[next.num] > curCost + next.cost){
                    dist[next.num] = curCost + next.cost;
                    pq.add(new Pos(next.num,curCost+next.cost));
                }
            }
        }
        int ans = 0;
        int maxTime = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] != Integer.MAX_VALUE){
                ans++;
                maxTime = Math.max(maxTime,dist[i]);
            }
        }
        System.out.println(ans-1 + " " + maxTime);
    }
}
