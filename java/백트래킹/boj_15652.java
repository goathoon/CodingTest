package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15652 {
    static int[] result;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        result = new int[m];
        backTracking(1,0,m);
    }
    static void backTracking(int before, int curDepth, int targetDepth){
        if (curDepth == targetDepth){
            for(int i = 0; i < targetDepth; i ++){
                System.out.printf("%d ",result[i]);
            }
            System.out.println();
            return;
        }
        for(int start = before; start <= n; start++){
            result[curDepth] = start;
            backTracking(start,curDepth + 1,targetDepth);
        }

    }
}
