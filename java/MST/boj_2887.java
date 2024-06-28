package MST;
import java.io.*;
import java.util.*;
public class boj_2887 {
    static class Pos {
        int x;
        int y;
        int z;
        int num;
        Pos(int x, int y, int z, int num){
            this.x = x;
            this.y = y;
            this.z = z;
            this.num = num;
        }
    }

    static class Edge{
        int n1;
        int n2;
        int cost;
        Edge(int n1, int n2, int cost){
            this.n1 = n1;
            this.n2 = n2;
            this.cost = cost;
        }
    }
    static int[] parent;
    static Pos[] pos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        parent = new int[N];
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }

        List<Edge> edges = new ArrayList<>();

        pos = new Pos[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            pos[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(pos, (p1,p2) -> p1.x - p2.x);
        for(int i = 0; i < N-1; i++){
            edges.add(new Edge(pos[i].num, pos[i+1].num, pos[i+1].x - pos[i].x));
        }

        Arrays.sort(pos, (p1,p2) -> p1.y - p2.y);
        for(int i = 0; i < N-1; i++){
            edges.add(new Edge(pos[i].num, pos[i+1].num, pos[i+1].y - pos[i].y));
        }

        Arrays.sort(pos, (p1,p2) -> p1.z - p2.z);
        for(int i = 0; i < N-1; i++){
            edges.add(new Edge(pos[i].num, pos[i+1].num, pos[i+1].z - pos[i].z));
        }

        long ans = 0;

        Collections.sort(edges, (e1,e2) -> e1.cost - e2.cost);
        for(Edge e : edges){
            int n1 = e.n1;
            int n2 = e.n2;
            int cost = e.cost;
            int pa = getParent(n1);
            int pb = getParent(n2);

            if(pa == pb) continue;

            union(n1,n2);
            ans += cost;
        }

        System.out.println(ans);

    }

    public static int getParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    public static void union(int a, int b){
        int pA = getParent(a);
        int pB = getParent(b);
        if(pA < pB){
            parent[pB] = pA;
        }
        else{
            parent[pA] = pB;
        }
    }

}
