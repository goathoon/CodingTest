package 위상정렬;
import java.io.*;
import java.util.*;
public class boj_1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] indegree = new int[N+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            indegree[end]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0) pq.offer(i);
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            System.out.printf("%d ",cur);
            for(int next : graph.get(cur)){
                if(--indegree[next] == 0){
                    pq.offer(next);
                }
            }
        }

    }
}
