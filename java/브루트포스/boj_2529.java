package 브루트포스;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class boj_2529 {
    static char[] chars;
    static boolean[] visit = new boolean[10];
    static long min;
    static String minS;
    static long max;
    static String maxS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        chars = new char[n];
        for(int i = 0; i < n; i++){
            chars[i] = st.nextToken().charAt(0);
        }
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        minS = "";
        maxS = "";

        for(int i = 0; i < visit.length; i++){
            visit[i] = false;
        }

        dfs(0,n+1, new LinkedList<>());
        System.out.println(maxS);
        System.out.println(minS);
    }

    public static void dfs(int idx, int depth, Deque<Integer> list){
        if(idx == depth){
            long ans = 0;
            for(int i = 0 ; i < depth; i++){
                int x = list.pollFirst();
                ans += x * Math.pow(10,depth-i-1);
                list.addLast(x);
            }
            min = Math.min(ans,min);
            if(min == ans){
                minS = "";
                StringBuilder sb = new StringBuilder();
                for(int i = 0 ; i < depth; i++){
                    int xx = list.pollFirst();
                    sb.append(xx);
                    list.addLast(xx);
                }
                minS = sb.toString();
            }
            max = Math.max(ans,max);
            if(max == ans){
                maxS = "";
                StringBuilder sb = new StringBuilder();
                for(int i = 0 ; i < depth; i++){
                    int xx = list.pollFirst();
                    sb.append(xx);
                    list.addLast(xx);
                }
                maxS = sb.toString();
            }
            return;
        }
        for(int i = 0; i < 10; i++){
            if(visit[i]) continue;
            if(idx == 0) {
                visit[i] = true;
                list.addLast(i);
                dfs(idx + 1, depth, list);
                list.pollLast();
                visit[i] = false;
            }
            else{
                if(chars[idx-1] == '>'){
                    if(list.peekLast() > i) {
                        visit[i] = true;
                        list.addLast(i);
                        dfs(idx + 1, depth, list);
                        list.pollLast();
                        visit[i] = false;
                    }
                }
                else{
                    if(list.peekLast() < i){
                        visit[i] = true;
                        list.addLast(i);
                        dfs(idx+1,depth,list);
                        list.pollLast();
                        visit[i] = false;
                    }
                }
            }
        }
    }
}
