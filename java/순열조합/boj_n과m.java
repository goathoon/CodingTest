package 순열조합;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class boj_n과m {
    static int N,M;
    static int[] numberArr;
    static boolean[] visited;
    static int[] output;
    static Set<String> ansSet;

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numberArr = new int[N];
        visited = new boolean[N];
        output = new int[M];
        ansSet = new LinkedHashSet<String>();
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++){
            numberArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numberArr);
        permutation(0);
        ansSet.forEach(x->System.out.println(x));
    }
    static void permutation(int cnt){
        StringBuilder sb = new StringBuilder();
        if (cnt == M){
            for(int i = 0; i < output.length; i ++){
                sb.append(output[i]).append(" ");
            }
            ansSet.add(sb.toString());
            return;
        }
        for(int i = 0; i < numberArr.length; i ++){
            if(!visited[i]){
                visited[i] = true;
                output[cnt] = numberArr[i];
                permutation(cnt+1);
                visited[i] = false;
            }
        }
    }
}
