package DP;

import java.io.*;
import java.util.StringTokenizer;

public class boj_9177 {
    static String s1;
    static String s2;
    static String concat;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            s1 = st.nextToken();
            s2 = st.nextToken();
            concat = st.nextToken();
            visit = new boolean[s1.length()+1][s2.length()+1];
            bw.write("Data set " + i +": ");
            if(dfs(0,0,0)){
                bw.write("yes");
            }
            else{
                bw.write("no");
            }
            bw.newLine();

        }
        bw.flush();
        bw.close();
    }
    public static boolean dfs(int idx1, int idx2, int concatIdx){
        if(concatIdx == concat.length()) return true;
        if(visit[idx1][idx2]) return false;

        boolean possible = false;
        if(idx1 < s1.length() && concat.charAt(concatIdx) == s1.charAt(idx1)){
            possible |= dfs(idx1+1,idx2,concatIdx+1);
            if(possible) return true;
            visit[idx1+1][idx2] = true;
        }

        if(idx2 < s2.length() && concat.charAt(concatIdx) == s2.charAt(idx2)){
            possible |= dfs(idx1,idx2+1,concatIdx+1);
            if(possible) return true;
            visit[idx1][idx2+1] = true;
        }

        return possible;
    }
}
