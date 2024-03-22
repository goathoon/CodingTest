package MST;

import java.io.*;
import java.util.*;

public class boj_6497 {
    static List<Pos> list;
    static int[] parent;
    static class Pos{
        int s;
        int e;
        int dist;
        Pos(int s, int e, int dist){
            this.s = s;
            this.e = e;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            if(N == 0 && R == 0) break;
            list = new ArrayList<>();
            parent = new int[N];
            for(int i = 0; i < parent.length; i++){
                parent[i] = i;
            }
            int sum = 0;
            for(int r = 0; r < R; r++){
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                list.add(new Pos(s, e, d));
                sum += d;
            }
            Collections.sort(list,(p1,p2)->p1.dist-p2.dist);
            int use = 0;
            for(Pos p : list){
                int s = p.s;
                int e = p.e;
                if(find(s)==find(e)) continue;
                union(s,e);
                use += p.dist;
            }
            System.out.println(sum-use);
        }
    }
    public static void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1<p2) parent[p2] = p1;
        else parent[p1] = p2;
    }
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
