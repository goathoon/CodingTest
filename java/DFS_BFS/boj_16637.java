package DFS_BFS;

import java.io.*;
import java.util.*;
public class boj_16637 {
    static int ans = Integer.MIN_VALUE;
    static char[] arr;
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        dfs(0,0);
        System.out.println(ans);
    }

    public static void dfs(int idx, int num){
        if(idx >= N){
            ans = Math.max(num,ans);
            return;
        }
        char op = idx > 0 ? arr[idx-1] : '+';
        // 괄호
        if(idx + 2 < N){
            dfs(idx+4, cal(num, cal(arr[idx]-'0',arr[idx+2]-'0',arr[idx+1]),op));
        }
        dfs(idx+2,cal(num,arr[idx]-'0',op));
    }

    public static int cal(int a, int b, char x){
        switch(x){
            case '+' :{
                return a + b;
            }
            case '-' :{
                return a - b;
            }
            case '*' :{
                return a * b ;
            }
        }
        return 0;
    }

}
