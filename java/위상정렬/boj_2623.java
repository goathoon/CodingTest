package 위상정렬;

import java.io.*;
import java.util.*;
public class boj_2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[N+1];
        for(int n = 0; n <= N; n++){
            graph.add(new ArrayList<>());
        }

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int curNode = Integer.parseInt(st.nextToken());
            for(int c = 1; c < cnt; c++){
                int nextNode = Integer.parseInt(st.nextToken());
                indegree[nextNode]++;
                graph.get(curNode).add(nextNode);
                curNode = nextNode;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int n = 1; n <= N; n++){
            if(indegree[n] == 0) q.add(n);
        }

        StringBuilder sb = new StringBuilder();
        int pollCnt = 0;
        while(!q.isEmpty()){
            int curNode = q.poll();
            pollCnt++;
            sb.append(curNode).append('\n');
            for(int next: graph.get(curNode)){
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }
        if(pollCnt != N) {
            System.out.println(0);
            return;
        }
        System.out.println(sb);
    }
}
