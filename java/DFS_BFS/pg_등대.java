package DFS_BFS;
import java.util.*;
public class pg_등대 {
    class Solution {
        int ans = 0;
        boolean[] light;
        boolean[] visit;
        List<List<Integer>> list;
        public class Node{
            int num;
            int cnt;
            Node(int num, int cnt){
                this.num = num;
                this.cnt = cnt;
            }
        }
        public int solution(int n, int[][] lighthouse) {
            ans = 0;
            list = new ArrayList<>();
            light = new boolean[n+1];
            visit = new boolean[n+1];
            for(int i = 0; i <= n; i++){
                list.add(new ArrayList<>());
            }
            for(int[] road : lighthouse){
                int n1 = road[0];
                int n2 = road[1];
                list.get(n1).add(n2);
                list.get(n2).add(n1);
            }
            dfs(1,0);
            return ans;
        }
        public boolean dfs(int root,int before){
            visit[root] = true;
            if(list.get(root).size() == 1 && list.get(root).get(0) == before){
                // 꺼져있음
                return false;
            }
            boolean need = false;
            for(int i = 0; i < list.get(root).size(); i++){
                for(int next : list.get(root)){
                    if(!visit[next]){
                        //하나라도 child가 꺼져있으면 root가 켜야한다.
                        if(!dfs(next,root)){
                            need = true;
                        }
                    }
                }
            }
            if(need) {
                ans++;
                return true;
            }
            return false;
        }
    }
}
