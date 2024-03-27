package 위상정렬;

import java.io.*;
import java.util.*;
public class boj_1516 {
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
        int N = Integer.parseInt(br.readLine());
        int[] indegree = new int[N+1];
        int[] dp = new int[N+1];
        int[] build = new int[N+1];
        PriorityQueue<Building> q = new PriorityQueue<>((b1,b2)->b1.cost-b2.cost);
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <=N; i++){
            graph.add(new ArrayList<>());
        }
//        Arrays.fill(dp,Integer.MAX_VALUE);

        for(int n = 1; n <= N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int i = 0;
            while(true){
                i++;
                int token = Integer.parseInt(st.nextToken());
                if(i==1){
                    build[n] = token;
                }
                if(token == -1){
                    break;
                }
                if(i >= 2){
                    indegree[n]++;
                    graph.get(token).add(n);
                }
            }
            if(indegree[n] == 0){
                q.add(new Building(n,build[n]));
            }
        }
        while(!q.isEmpty()){
            Building b = q.poll();
            dp[b.num] = Math.max(dp[b.num],b.cost);
            for(int nextNum : graph.get(b.num)){
                indegree[nextNum]--;
                if(indegree[nextNum] == 0){
                    q.add(new Building(nextNum, b.cost + build[nextNum]));
                }
            }
        }
        for(int i = 1; i <= N; i++){
            System.out.println(dp[i]);
        }
    }
}
