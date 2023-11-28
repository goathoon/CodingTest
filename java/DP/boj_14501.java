package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14501 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[][] day = new int[tc+1][2];
        int[] totalPrice = new int[tc+2];
        for (int i = 1; i<tc+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            day[i] = new int[]{t, p};

        }
        int maxPrice = 0;
        for (int i = 1; i < tc+1; i++){
            int takeDay = day[i][0];
            int takePrice = day[i][1];
            for (int nextDay = i + takeDay; nextDay <= tc+1; nextDay++){
                totalPrice[nextDay] = Math.max(totalPrice[nextDay],totalPrice[i] + takePrice);
            }
        }
        System.out.println(totalPrice[tc+1]);
    }
}
