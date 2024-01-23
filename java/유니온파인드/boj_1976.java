package 유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_1976 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i = 1; i < N; i ++){
            parent[i] = i;
        }
        for(int i = 1; i <= N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1)
                    union(i,j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for(int i = 1; i <M; i ++){
            int end = Integer.parseInt(st.nextToken());
            if(isSameParent(start,end)) start = end;
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    static int getParent(int x){
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    static void union(int a, int b){
        // 그냥 p1 = parent[a]; 하면 안된다. -> 갱신이 아직 일어나지 않을 수 있음.
        // 예를들어, 1,2 / 3,4 가 union이 순차적으로 이루어 지면 [1,1,3,3] 의 parent배열이 만들어지는데,
        // 그 후 2,3을 union하면 [1,1,1,3]이 됨. 그러면 4의 parent는 3인 상황이 벌어질 수 있다. 따라서 union과정에서도 getParent함수를 호출해야함.
        int p1 = getParent(a);
        int p2 = getParent(b);
        if(p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
    }
    static boolean isSameParent(int a, int b){
        int p1 = getParent(a);
        int p2 = getParent(b);
        if(p1==p2) return true;
        else return false;
    }
}
