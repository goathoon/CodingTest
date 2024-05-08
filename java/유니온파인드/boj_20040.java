package 유니온파인드;

import java.io.*;
import java.util.*;

public class boj_20040 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        for(int n = 0; n < N; n++){
            parent[n] = n;
        }

        int ans = 0;
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(getParent(a) == getParent(b)){
                ans = m+1;
                break;
            }
            union(a,b);
        }
        System.out.println(ans);
    }
    public static int getParent(int x){
        if(parent[x] == x){
            return parent[x];
        }
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
