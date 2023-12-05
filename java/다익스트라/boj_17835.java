package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_17835 {
    static class Node implements Comparable<Node>{
        int cityNum;
        long dist;
        Node(int cityNum, long dist){
            this.cityNum = cityNum;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(this.dist, node.dist);
        }
    }
    static class Answer{
        private int cityNum;
        private long dist;
        Answer(int cityNum, long dist){
            this.cityNum = cityNum;
            this.dist = dist;
        }
        void setCityNumAndDist(int cityNum,long dist){
            this.cityNum = cityNum;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        int city = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        // 어려웠던 부분
        // Integer[] cities = new Integer[city+1] 이랑 다른건 없다.
        ArrayList<Node>[] cities = new ArrayList[city + 1];
        for (int i = 0 ; i < city + 1; i ++){
            cities[i] = new ArrayList<Node>();
        }
        int[] targetCityNums = new int[target];
        for (int i = 0; i<road; i ++){
            st = new StringTokenizer(br.readLine(), " ");
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            cities[from].add(new Node(to,dist));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<target; i ++){
            targetCityNums[i] = Integer.parseInt(st.nextToken());
        }

        long[] cityDist = new long[city+1];
        boolean [] visited = new boolean[city+1];
        long INF = Long.MAX_VALUE;
        Arrays.fill(cityDist,INF);
        for(int cityNum : targetCityNums){
            // 문제 의도를 잘 파악할 것
            // Arrays.fill(cityDist,INF);
            Arrays.fill(visited,false);
            dijkstra(cityNum,cities,cityDist,visited);

        }
        Answer answer = getMinCityAndDist(cityDist);
        System.out.println(answer.cityNum);
        System.out.println(answer.dist);
    }

    static void dijkstra(int startCity,ArrayList<Node>[] cities, long[] cityDist, boolean[] visited){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startCity,0));
        cityDist[startCity] = 0;
        while (!pq.isEmpty()){
            Node curNode = pq.poll();
            long curDist = curNode.dist;
            int curCity = curNode.cityNum;
            if (visited[curCity]) continue;

            visited[curCity] = true;

            // ArrayList 순회방법
            for (Node next: cities[curCity]){
                int nextCity = next.cityNum;
                long dist = next.dist;
                if(cityDist[nextCity] > curDist + dist){
                    pq.offer(new Node(nextCity,curDist+dist));
                    cityDist[nextCity] = curDist + dist;

                }
            }
        }
    }
    static Answer getMinCityAndDist(long[] cityDist){
        Answer answer = new Answer(0,0);
        long val = -1;
        for(int idx = cityDist.length-1; idx > 0; idx--){
            val = Math.max(val,cityDist[idx]);
            if (val == cityDist[idx]){
                answer.setCityNumAndDist(idx,val);
            }
        }
        return answer;
    }
}
