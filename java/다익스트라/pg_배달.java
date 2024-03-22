package 다익스트라;
import java.util.*;
public class pg_배달 {

    class Solution {
        public int solution(int N, int[][] road, int K) {
            class Pos{
                int num;
                int dist;
                Pos(int num, int dist){
                    this.num = num;
                    this.dist = dist;
                }
            }
            int[] dist = new int[N+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            List<List<Pos>> graph = new ArrayList<>();
            for(int i = 0; i <= N; i++){
                graph.add(new ArrayList<>());
            }
            for(int[] r : road){
                graph.get(r[0]).add(new Pos(r[1],r[2]));
                graph.get(r[1]).add(new Pos(r[0],r[2]));
            }
            PriorityQueue<Pos> pq = new PriorityQueue<>((p1,p2)->p1.dist-p2.dist);
            pq.add(new Pos(1,0));
            dist[1] = 0;
            while(!pq.isEmpty()){
                Pos cur = pq.poll();
                int curDist = cur.dist;
                int curNum = cur.num;
                if(dist[curNum] < curDist) continue;
                for(Pos next : graph.get(curNum)){
                    if(dist[next.num] > curDist + next.dist){
                        dist[next.num] = curDist + next.dist;
                        pq.add(new Pos(next.num, curDist+next.dist));
                    }
                }
            }
            int ans = 0;
            for(int i = 1; i <= N; i++){
                if(dist[i] <= K){
                    ans++;
                }
            }
            return ans;
        }
    }
}
