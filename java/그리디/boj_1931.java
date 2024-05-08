package 그리디;

import java.io.*;
import java.util.*;

public class boj_1931 {
    static class MyComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] meet = new int[N][2];
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            meet[n][0] = s;
            meet[n][1] = e;
        }
        Arrays.sort(meet,new MyComparator());
        int s = -1, e = -1;
        int ans = 0;
        for(int m = 0; m < meet.length; m++){
            if(meet[m][0] >= e){
                ans++;
                s = meet[m][0];
                e = meet[m][1];
            }
            else{
                if(meet[m][1] < e){
                    s = meet[m][0];
                    e = meet[m][1];
                }
            }
        }
        System.out.println(ans);
    }
}
