package 위상정렬;
import java.io.*;
import java.util.*;
public class boj_1005_1 {
    static class Build {
        int num;
        Long startTime;
        Build(int num, Long startTime){
            this.num = num;
            this.startTime = startTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long[] buildTime;
        int[] indegree;
        long[] maxStartTime;
        List<List<Integer>> graph;
        Queue<Build> order;

        int N = Integer.parseInt(br.readLine());


        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            int building = Integer.parseInt(st.nextToken()), cnt = Integer.parseInt(st.nextToken());
            buildTime = new long[building+1];
            maxStartTime = new long[building+1];
            indegree = new int[building+1];
            order = new LinkedList<>();
            graph = new ArrayList<>();
            for(int i = 0; i <= building; i++){
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= building; i++) {
                buildTime[i] = Long.parseLong(st.nextToken());
            }

            for(int i = 0; i < cnt; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end);
                indegree[end]++;
            }

            int target = Integer.parseInt(br.readLine());

            for(int i = 1; i <= building; i++){
                if(indegree[i] == 0){
                    order.offer(new Build(i, 0L));
                }
            }

            while(!order.isEmpty()){
                Build curBuild = order.poll();
                if(curBuild.num == target){
                    System.out.println(curBuild.startTime + buildTime[curBuild.num]);
                    break;
                }
                for(int next : graph.get(curBuild.num)){
                    indegree[next]--;
                    maxStartTime[next] = Math.max(maxStartTime[next], curBuild.startTime + buildTime[curBuild.num]);
                    if(indegree[next] == 0){
                        order.offer(new Build(next, maxStartTime[next]));
                    }
                }
            }

        }
    }
}
