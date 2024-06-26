package 구현;
import java.io.*;
import java.util.*;
public class boj_23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int hCnt = 0;
        for(int h = 0; h < row; ){
            hCnt++;
            h += (H+1);
        }

        int wCnt = 0;
        for(int w = 0; w < col; ){
            wCnt++;
            w += (W+1);
        }

        System.out.println(hCnt * wCnt);

    }
}
