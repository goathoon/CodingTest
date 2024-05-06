package 브루트포스;

import java.io.*;
import java.util.*;

public class boj_1535 {
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] p = new int[N][2];
        st = new StringTokenizer(br.readLine(), " ");
        for(int n = 0; n < N; n++){
            p[n][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int n = 0; n < N; n++){
            p[n][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0,p,100,0);
        System.out.println(answer);
    }
    public static void dfs(int depth, int[][] p, int curHealth, int curPlease){
        if(curHealth <= 0) return;

        if(depth == p.length){
            answer = Math.max(curPlease,answer);
            return;
        }

        dfs(depth+1, p, curHealth-p[depth][0], curPlease+p[depth][1]);
        dfs(depth+1, p, curHealth, curPlease);
    }
}
