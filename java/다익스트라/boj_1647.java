package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1647 {
    public static void main(String[] args) throws IOException {
        class Node{
            int cost;
            int num;
            Node(int cost, int num) {
                this.cost = cost;
                this.num = num;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int home = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[home+1];
        List<List<Node>> list = new ArrayList<>();
        for(int i = 0; i < home+1; i++){
            list.add(new ArrayList<>());
        }

        for(int r = 0; r < road; r++){
            st = new StringTokenizer(br.readLine(), " ");
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(startNode).add(new Node(cost,endNode));
            list.get(endNode).add(new Node(cost,startNode));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        pq.add(new Node(0,1));
        int maxCost = 0;
        long ans = 0;
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curNum = curNode.num;
            int curCost = curNode.cost;
            if(!visited[curNum]) {
                maxCost = Math.max(maxCost, curCost);
                visited[curNum] = true;
                ans += curCost;
                for (Node n : list.get(curNum)) {
                    pq.add(n);
                }
            }
        }
        ans -= maxCost;
        System.out.println(ans);
    }
}
