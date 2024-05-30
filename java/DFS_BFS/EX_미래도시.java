package DFS_BFS;

import java.io.*;
import java.util.*;

public class EX_미래도시 {
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        st = new StringTokenizer(br.readLine(), " ");
        int target = Integer.parseInt(st.nextToken()), first = Integer.parseInt(st.nextToken());
        int ans = 0;
        boolean[] visit = new boolean[N+1];
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(1,0));
        visit[1] = true;
        while(!q.isEmpty()){
            Pos curPos = q.poll();
            int curNum = curPos.num;
            int curCost = curPos.cost;
            if(curNum == first){
                ans += curCost;
                break;
            }
            for(int next : graph.get(curNum)){
                if(!visit[next]){
                    q.offer(new Pos(next,curCost+1));
                    visit[next] = true;
                }
            }
        }

        Arrays.fill(visit,false);
        q.clear();
        q.offer(new Pos(first,0));
        visit[first] = true;
        while(!q.isEmpty()){
            Pos curPos = q.poll();
            int curNum = curPos.num;
            int curCost = curPos.cost;
            if(curNum == target){
                ans += curCost;
                break;
            }
            for(int next : graph.get(curNum)){
                if(!visit[next]){
                    q.offer(new Pos(next,curCost+1));
                    visit[next] = true;
                }
            }
        }
        System.out.println(ans);
        // 예외처리 안되어있음
    }
}
