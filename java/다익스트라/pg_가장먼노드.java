package 다익스트라;
import java.util.*;
public class pg_가장먼노드 {

    class Solution {
        static boolean[] visited;
        public int solution(int n, int[][] edge) {
            List<Integer>[] list = new ArrayList[n+1];
            visited = new boolean[n+1];

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int i = 0; i <= n; i++){
                list[i] = new ArrayList<Integer>();
            }
            for(int[] e: edge){
                int v1 = e[0];
                int v2 = e[1];
                list[v1].add(v2);
                list[v2].add(v1);
            }
            pq.add(new Node(1,0));
            visited[1] = true;
            int maxDist = 0;
            int answer = 0;
            while(!pq.isEmpty()){
                Node node = pq.poll();
                int curV = node.v;
                int curD = node.dist;
                if(maxDist < curD){
                    maxDist = curD;
                    answer = 0;
                }
                answer ++;
                for(int nextV: list[curV]){
                    if(!visited[nextV]){
                        pq.add(new Node(nextV,curD+1));
                        visited[nextV] = true;
                    }
                }
            }
            return answer;
        }
    }
    class Node implements Comparable<Node>{
        int v;
        int dist;
        Node(int v, int dist){
            this.v = v;
            this.dist = dist;
        }
        public int compareTo(Node n){
            return this.dist - n.dist;
        }
    }
}
