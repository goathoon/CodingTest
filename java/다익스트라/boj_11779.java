package 다익스트라;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_11779 {
    public static void main(String[] args) throws IOException {
        class Node implements Comparable<Node>{
            int cost;
            int city;
            Node(int cost, int city){
                this.cost = cost;
                this.city = city;
            }
            public int compareTo(Node node){
                return Integer.compare(this.cost, node.cost);
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cityCnt = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        ArrayList<Node>[] edges = new ArrayList[cityCnt+1];
        for(int i = 0; i<cityCnt + 1; i++){
            edges[i] = new ArrayList<>();
        }
        int[][] visit = new int[cityCnt+1][2];
        for (int i = 1; i <cityCnt + 1; i++){
            visit[i][0] = Integer.MAX_VALUE;
        }
        for(int b = 0; b < bus; b++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[s].add(new Node(cost,e));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int first = Integer.parseInt(st.nextToken());
        int last = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,first));
        visit[first][0] = 0;
        visit[first][1] = -1;
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            if(visit[curNode.city][0] < curNode.cost) continue;
            for(Node n : edges[curNode.city]){
                int nextCost = n.cost + curNode.cost;
                int nextCity = n.city;
                if (visit[nextCity][0] <= nextCost) continue;

                visit[nextCity][0] = nextCost;
                visit[nextCity][1] = curNode.city;
                pq.add(new Node(nextCost, nextCity));
            }
        }
        System.out.println(visit[last][0]);

        int cityCount = 1;
        int [] cityArr = new int[1001];
        int beforeCity = visit[last][1];
        cityArr[cityCount] = last;
        while (beforeCity != -1){
            cityCount += 1;
            cityArr[cityCount] = beforeCity;
            beforeCity = visit[beforeCity][1];
        }
        cityArr[cityCount] = first;
        System.out.println(cityCount);
        StringBuilder sb = new StringBuilder();

        for(int i = cityCount; i>=1 ; i --){
            sb.append(cityArr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
