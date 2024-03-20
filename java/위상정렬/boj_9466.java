package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_9466 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            List<Integer> graph = new ArrayList<>();
            graph.add(0);
            int len = Integer.parseInt(br.readLine());
            int[] indegree = new int[len+1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= len; i++){
                int next = Integer.parseInt(st.nextToken());
                graph.add(next);
                indegree[next]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i <= len; i++){
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
            while(!q.isEmpty()){
                int curN = q.poll();
                int next = graph.get(curN);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
            int ans = 0;
            for(int i = 1; i <= len; i++){
                if(indegree[i] == 0){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
