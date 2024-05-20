package 플로이드;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean [][] grid = new boolean [N+1][N+1];

        for(int k = 0; k < K; k++){
            st = new StringTokenizer(br.readLine()," ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            grid[first][second] = true;
        }

        for(int x = 1; x <= N; x++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(grid[i][x] && grid[x][j]) grid[i][j] = true;
                }
            }
        }

        int X = Integer.parseInt(br.readLine());
        for(int x = 0; x < X; x++){
            st = new StringTokenizer(br.readLine()," ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if(grid[first][second]){
                bw.write("-1");
            }else if(grid[second][first]){
                bw.write("1");
            }
            else{
                bw.write("0");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}
