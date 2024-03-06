package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1707 {
    class Solution{
        static int[] visited;
        static List<List<Integer>> graph;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int K = Integer.parseInt(br.readLine());
            for(int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                graph = new ArrayList<>();
                visited = new int[V + 1];
                for (int v = 0; v <= V; v++) {
                    graph.add(new ArrayList<>());
                }
                for (int e = 0; e < E; e++) {
                    StringTokenizer st1 = new StringTokenizer(br.readLine());
                    int v1 = Integer.parseInt(st1.nextToken());
                    int v2 = Integer.parseInt(st1.nextToken());
                    graph.get(v1).add(v2);
                    graph.get(v2).add(v1);
                }
                boolean isBip = true;
                // 어쩃거나 순회를 해서 visit되어있는 노드랑 현재 노드랑 같아지면 안된다.
                for (int v = 1; v <= V; v++) {
                    if(visited[v] ==0){
                        isBip = dfs(v,1);
                        if(!isBip) break;
                    }
                }
                if(isBip) System.out.println("YES");
                else System.out.println("NO");
            }

        }
        public static boolean dfs(int curV,int color){
            boolean isBip = true;
            visited[curV] = color;
            for(int next : graph.get(curV)){
                if(visited[next] == visited[curV]){
                    return false;
                }
                if(visited[next] == 0){
                    isBip = isBip && dfs(next,color*-1);
                }
            }
            return isBip;
        }
    }
    class Solution2{
        static int[] visited;
        static List<List<Integer>> graph;
        static class Node{
            int v;
            int color;
            Node(int v, int color){
                this.v = v;
                this.color = color;
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int K = Integer.parseInt(br.readLine());
            for(int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                graph = new ArrayList<>();
                visited = new int[V + 1];
                for (int v = 0; v <= V; v++) {
                    graph.add(new ArrayList<>());
                }
                for (int e = 0; e < E; e++) {
                    StringTokenizer st1 = new StringTokenizer(br.readLine());
                    int v1 = Integer.parseInt(st1.nextToken());
                    int v2 = Integer.parseInt(st1.nextToken());
                    graph.get(v1).add(v2);
                    graph.get(v2).add(v1);
                }
                boolean isBip = true;
                for(int v = 1; v <=V; v++){
                    if(visited[v] == 0){
                        visited[v] = 1;
                        isBip = bfs(v);
                        if(!isBip) break;
                    }
                }
                if(isBip) System.out.println("YES");
                else System.out.println("NO");
            }
        }
        public static boolean bfs(int curV){
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(curV,1));
            while(!q.isEmpty()){
                Node n = q.poll();
                int curColor = n.color;
                for(int nextV : graph.get(n.v)){
                    if(visited[nextV] == curColor){
                        return false;
                    }
                    if(visited[nextV] == 0){
                        visited[nextV] = curColor * -1;
                        q.add(new Node(nextV,curColor*-1));
                    }
                }

            }
            return true;
        }
    }
    class Main {
        static int[] visited;
        static List<List<Integer>> graph;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int K = Integer.parseInt(br.readLine());
            for(int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                graph = new ArrayList<>();
                visited = new int[V + 1];
                for (int v = 0; v <= V; v++) {
                    graph.add(new ArrayList<>());
                }
                for (int e = 0; e < E; e++) {
                    StringTokenizer st1 = new StringTokenizer(br.readLine());
                    int v1 = Integer.parseInt(st1.nextToken());
                    int v2 = Integer.parseInt(st1.nextToken());
                    graph.get(v1).add(v2);
                    graph.get(v2).add(v1);
                }
                boolean isBip = true;
                // 어쩃거나 순회를 해서 visit되어있는 노드랑 현재 노드랑 같아지면 안된다.
                for (int v = 1; v <= V; v++) {
                    if(visited[v] ==0){
                        isBip = dfs(v);
                        if(!isBip) break;
                    }
                }
                if(isBip) System.out.println("YES");
                else System.out.println("NO");
            }

        }
        public static boolean dfs(int curV){
            boolean isBip = true;
            for(int next : graph.get(curV)){
                if(visited[next] != 0){
                    if(visited[curV] == 0){
                        visited[curV] = visited[next] * -1;
                    }
                    else{
                        if(visited[curV] == visited[next]){
                            return false;
                        }
                    }
                }
                else{
                    if(visited[curV] == 0){
                        visited[curV] = 1;
                        visited[next] = -1;
                    }else{
                        visited[next] = visited[curV] * -1;
                    }
                    isBip = isBip && dfs(next);
                }
            }
            return isBip;
        }
        /** DFS제대로 공부한게 맞는지..?
         *  public static boolean dfs(int curV){
         *         for(int next : graph.get(curV)){
         *             if(visited[next] != 0){
         *                 if(visited[curV] == 0){
         *                     visited[curV] = visited[next] * -1;
         *                 }
         *                 else{
         *                     if(visited[curV] == visited[next]){
         *                         return false;
         *                     }
         *                 }
         *             }
         *             else{
         *                 if(visited[curV] == 0){
         *                     visited[curV] = 1;
         *                     visited[next] = -1;
         *                 }else{
         *                     visited[next] = visited[curV] * -1;
         *                 }
         *                 return dfs(next);
         *             }
         *         }
         *         return true;
         *     }
         */
    }
}
