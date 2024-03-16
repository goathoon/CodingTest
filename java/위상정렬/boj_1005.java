package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1005 {
    public static void main(String[] args) throws IOException {
        class Building{
            int num;
            int cost;
            Building(int num, int cost){
                this.num = num;
                this.cost = cost;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < TC; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] build = new int[N+1];
            int[] answers = new int[N+1];
            int[] indegree = new int[N+1];
            st = new StringTokenizer(br.readLine(), " ");
            List<List<Integer>> graph = new ArrayList<>();
            graph.add(new ArrayList<>());
            for(int i = 1; i <= N; i++){
                graph.add(new ArrayList<>());
                build[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end);
                indegree[end]++;
            }
            int target = Integer.parseInt(br.readLine());
            Queue<Building> q = new PriorityQueue<>((b1,b2)->b1.cost-b2.cost);
            for(int i = 1; i <= N; i++){
                if(indegree[i] == 0){
                    q.add(new Building(i,build[i]));
                }
            }
            while(!q.isEmpty()){
                Building curBuilding = q.poll();
                int curNum = curBuilding.num;
                int curCost = curBuilding.cost;
                answers[curNum] = curCost;
                for(int next : graph.get(curNum)){
                    indegree[next] --;
                    if(indegree[next]==0){
                        q.add(new Building(next,curCost + build[next]));
                    }
                }
            }
            System.out.println(answers[target]);
        }

    }
    class Solution2{
        public static void main(String[] args) throws IOException {


            class Building {
                int num;
                int cost;

                Building(int num, int cost) {
                    this.num = num;
                    this.cost = cost;
                }
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int TC = Integer.parseInt(br.readLine());
            for (int t = 0; t < TC; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int N = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());
                int[] build = new int[N + 1];
                int[] answers = new int[N + 1];
                int[] indegree = new int[N + 1];
                st = new StringTokenizer(br.readLine(), " ");
                List<List<Integer>> graph = new ArrayList<>();
                graph.add(new ArrayList<>());
                for (int i = 1; i <= N; i++) {
                    graph.add(new ArrayList<>());
                    build[i] = Integer.parseInt(st.nextToken());
                    answers[i] = build[i];
                }
                for (int i = 0; i < K; i++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    graph.get(start).add(end);
                    indegree[end]++;
                }
                int target = Integer.parseInt(br.readLine());
                Queue<Building> q = new LinkedList<>();
                for (int i = 1; i <= N; i++) {
                    if (indegree[i] == 0) {
                        q.add(new Building(i, build[i]));
                    }
                }
                while (!q.isEmpty()) {
                    Building curBuilding = q.poll();
                    int curNum = curBuilding.num;
                    int curCost = curBuilding.cost;
                    for (int next : graph.get(curNum)) {
                        indegree[next]--;
                        answers[next] = Math.max(answers[next], curCost + build[next]);
                        if (indegree[next] == 0) {
                            q.add(new Building(next, answers[next]));
                        }
                    }
                }
                System.out.println(answers[target]);
            }
        }
    }
}
