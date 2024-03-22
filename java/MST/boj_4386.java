package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_4386 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        class Dist implements Comparable<Dist>{
            int start;
            int end;
            float dist;
            public int compareTo(Dist d){
                if(this.dist-d.dist <0){
                    return -1;
                }
                else if (this.dist == d.dist) return 0;
                return 1;
            }
            Dist(int start, int end, float dist){
                this.start = start;
                this.end = end;
                this.dist =dist;
            }
        }
        class Pos{
            float x;
            float y;
            Pos(float x, float y){
                this.x = x;
                this.y = y;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Dist> dist = new ArrayList<>();
        Pos[] poses = new Pos[N+1];
        parent = new int[N+1];

        for(int i = 1; i <= N; i++){
            parent[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            poses[i] = new Pos(Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken()));
            for(int j = i-1; j >= 1; j--){
                dist.add(new Dist(i,j,(float)Math.sqrt(Math.pow(poses[i].x - poses[j].x,2) + Math.pow(poses[i].y - poses[j].y,2))));
            }
        }
        Collections.sort(dist);
        float ans = 0;
        for(Dist d : dist){
            int s = d.start;
            int e = d.end;
            if(find(s) == find(e)) continue;
            union(s,e);
            ans += d.dist;
        }
        System.out.println( ((int)(ans*100)) /100f);
    }
    public static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a <= p_b){
            parent[p_b] = p_a;
        }else {
            parent[p_a] = p_b;
        }
    }
    public static int find(int x){
        if (parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
