package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_18352 {
    public static void main(String[] args) throws IOException {
        class Node{
            int city;
            int dist;

            Node(int city, int dist) {
                this.city = city;
                this.dist = dist;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int city = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());
        int targetDist = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[city+1];
        LinkedList<Integer>[] cityToCity = new LinkedList[city+1];
        for(int i = 0 ; i < city+1; i++){
            cityToCity[i] = new LinkedList<>();
        }
        for(int i = 0; i< road; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            cityToCity[start].add(end);
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(startCity,0));
        int targetCnt = 0;
        List<Integer> targetCity = new ArrayList<>();
        while (!q.isEmpty()){
            Node curNode = q.poll();
            int curDist = curNode.dist;
            int curCity = curNode.city;
            if(curDist == targetDist){
                targetCnt ++;
                targetCity.add(curCity);
                continue;
            }
            visit[curCity] = true;
            for(int n : cityToCity[curCity]){
                if (!visit[n]){
                    visit[n] = true;
                    q.add(new Node(n,curDist + 1));
                }
            }
        }
        if (targetCnt == 0){
            System.out.println(-1);
        }
        else{
            Integer[] arr = targetCity.toArray(new Integer[0]);
            Arrays.sort(arr);
            for(int c : arr){
                System.out.println(c);
            }
        }
    }
}
