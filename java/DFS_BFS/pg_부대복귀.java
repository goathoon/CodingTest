package DFS_BFS;
import java.util.*;
public class pg_부대복귀 {

    class Solution {
        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            class Pos{
                int num;
                int cnt;
                Pos(int num, int cnt){
                    this.num = num;
                    this.cnt = cnt;
                }
            }
            Set<Integer> set = new HashSet<>();
            for(int s : sources){
                set.add(s);
            }
            int[] answer = new int[sources.length];
            Arrays.fill(answer,-1);
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }
            boolean[] visit = new boolean[n+1];
            for(int[] r : roads){
                graph.get(r[0]).add(r[1]);
                graph.get(r[1]).add(r[0]);
            }
            Queue<Pos> q = new LinkedList<>();
            q.add(new Pos(destination,0));
            visit[destination] = true;
            while(!q.isEmpty()){
                Pos cur = q.poll();
                if(set.contains(cur.num)){
                    for(int i = 0; i < sources.length; i++){
                        if(sources[i] == cur.num){
                            answer[i] = cur.cnt;
                        }
                    }
                }
                for(int next : graph.get(cur.num)){
                    if(!visit[next]){
                        q.add(new Pos(next,cur.cnt+1));
                        visit[next] = true;
                    }
                }
            }
            return answer;
        }
    }
}
