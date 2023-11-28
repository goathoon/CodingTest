package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        for (int startDay = 1; startDay < tc+1; startDay++){
            int nextDay = startDay + day[startDay][0];
            for (int i = nextDay; i <= tc + 1; i ++) {
                totalPrice[i]
                        = Math.max(totalPrice[i], totalPrice[startDay] + day[startDay][1]);
                maxPrice = Math.max(maxPrice, totalPrice[i]);

            }
        }
        System.out.println(maxPrice);
    }
}
