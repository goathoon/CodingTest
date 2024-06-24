package DP;
import java.io.*;
import java.util.*;
public class boj_15645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] max = new int[N][3];
        int[][] min = new int[N][3];
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < 3; c++){
                int val = Integer.parseInt(st.nextToken());
                max[n][c] = val;
                min[n][c] = val;
            }
        }
        for(int n = 1; n < N; n++){
            int leftMax = Math.max(max[n-1][0], max[n-1][1]);
            int rightMax = Math.max(max[n-1][1], max[n-1][2]);
            int midMax = Math.max(leftMax,rightMax);

            int leftMin = Math.min(min[n-1][0], min[n-1][1]);
            int rightMin = Math.min(min[n-1][1], min[n-1][2]);
            int midMin = Math.min(leftMin, rightMin);

            max[n][0] = leftMax + max[n][0];
            min[n][0] = leftMin + min[n][0];
            max[n][1] = midMax + max[n][1];
            min[n][1] = midMin + min[n][1];
            max[n][2] = rightMax + max[n][2];
            min[n][2] = rightMin + min[n][2];
        }
        int ansMax = Math.max(Math.max(max[N-1][0], max[N-1][1]), max[N-1][2]);
        int ansMin = Math.min(Math.min(min[N-1][0], min[N-1][1]), min[N-1][2]);

        System.out.println(ansMax + " " + ansMin);
    }
}
