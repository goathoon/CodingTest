package 다익스트라;
import java.io.*;
import java.util.*;
class Node{
    int num;
    int dist;
    int max;
    Node(int num, int dist){
        this.num = num;
        this.dist = dist;
    }
    Node(int num, int dist, int max){
        this.num = num;
        this.dist = dist;
        this.max = max;
    }
}
public class boj_15971 {
    class 다익스트라_DFS없이최대값저장{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            List<List<Node>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int n = 1; n < N; n++) {
                st = new StringTokenizer(br.readLine(), " ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                graph.get(n1).add(new Node(n2, dist));
                graph.get(n2).add(new Node(n1, dist));
            }

            int[] dist = new int[N + 1];
            int[] beforeNum = new int[N + 1];
            for (int i = 0; i < dist.length; i++) {
                dist[i] = Integer.MAX_VALUE;
                beforeNum[i] = i;
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
            pq.offer(new Node(start, 0,0));
            dist[start] = 0;
            while (!pq.isEmpty()) {
                Node curNode = pq.poll();
                int curNum = curNode.num;
                int curDist = curNode.dist;
                if (dist[curNum] < curDist) continue;
                if(curNum == end){
                    System.out.println(dist[curNum] - curNode.max);
                    break;
                }
                for (Node nextNode : graph.get(curNum)) {
                    int nextNum = nextNode.num;
                    int addDist = nextNode.dist;
                    if (curDist + addDist <= dist[nextNum]) {
                        dist[nextNum] = curDist + addDist;
                        beforeNum[nextNum] = curNum;
                        pq.offer(new Node(nextNum, curDist + addDist, Math.max(curNode.max, addDist)));
                    }
                }
            }
        }
    }
    class 다익스트라_DFS {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            List<List<Node>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int n = 1; n < N; n++) {
                st = new StringTokenizer(br.readLine(), " ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                graph.get(n1).add(new Node(n2, dist));
                graph.get(n2).add(new Node(n1, dist));
            }

            int[] dist = new int[N + 1];
            int[] beforeNum = new int[N + 1];
            for (int i = 0; i < dist.length; i++) {
                dist[i] = Integer.MAX_VALUE;
                beforeNum[i] = i;
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
            pq.offer(new Node(start, 0));
            dist[start] = 0;
            while (!pq.isEmpty()) {
                Node curNode = pq.poll();
                int curNum = curNode.num;
                int curDist = curNode.dist;
                if (dist[curNum] < curDist) continue;

                for (Node nextNode : graph.get(curNum)) {
                    int nextNum = nextNode.num;
                    int addDist = nextNode.dist;
                    if (curDist + addDist <= dist[nextNum]) {
                        dist[nextNum] = curDist + addDist;
                        beforeNum[nextNum] = curNum;
                        pq.offer(new Node(nextNum, curDist + addDist));
                    }
                }
            }
            System.out.println(dist[end] - dfs(end, start, 0, dist, beforeNum));
        }

        public static int dfs(int cur, int end, int max, int[] dist, int[] beforeNum) {
            if (cur == end) {
                return max;
            }

            int curDist = dist[cur];
            int beforeDist = dist[beforeNum[cur]];
            int diffDist = curDist - beforeDist;
            int newMax = Math.max(max, diffDist);

            return dfs(beforeNum[cur], end, newMax, dist, beforeNum);

        }
    }
}
