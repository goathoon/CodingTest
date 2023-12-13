package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_18352 {
    static class Node implements Comparable<Node>{
        int pos;
        int dist;
        Node(int dist, int pos){
            this.pos = pos;
            this.dist = dist;
        }
        public int compareTo(Node n){
            return Integer.compare(this.dist,n.dist);
        }

    }
    static ArrayList<Node>[] nodeList;
    static int[] distArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int node = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());
        int targetDist = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        distArr = new int[node+1];
        nodeList = new ArrayList[node+1];
        for(int i = 1; i < node+1; i++){
            nodeList[i] = new ArrayList<>();
        }
        Arrays.fill(distArr, Integer.MAX_VALUE);
        for(int i = 0; i < road; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodeList[s].add(new Node(1,e));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,startNode));
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curDist = curNode.dist;
            int curPos = curNode.pos;

            if (distArr[curPos] <= curDist) continue;
            distArr[curPos] = curDist;
            for(Node n : nodeList[curPos]){
                pq.offer(new Node(curDist + n.dist, n.pos));
            }
        }
        boolean exist = false;
        for(int i = 1 ; i <node+1; i ++){
            if( distArr[i] == targetDist){
                System.out.println(i);
                exist = true;
            }
        }
        if(!exist) System.out.println(-1);
    }
}
