package 브루트포스;
import java.io.*;
import java.util.*;
public class boj_14658 {
    static class Pos{
        int col;
        int row;
        Pos(int col, int row){
            this.col = col;
            this.row = row;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int col = Integer.parseInt(st.nextToken()), row = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        Pos[] poses = new Pos[K];
        for(int k = 0; k < K; k++){
            st = new StringTokenizer(br.readLine());
            poses[k] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int maxCnt = 0;
        for(int i = 0; i < K; i++){
            Pos p1 = poses[i];
            for(int j = 0; j < K; j++){
                Pos p2 = poses[j];
                int startC = p1.col;
                int startR = p2.row;
                if(Math.abs(p2.col - startC) > L || Math.abs(startR - p1.row) > L) continue;

                int cnt = 0;
                for(int p = 0; p < K; p++){
                    Pos checkP = poses[p];
                    int curR = checkP.row;
                    int curC = checkP.col;
                    if(startR <= curR && curR <= startR + L && startC <= curC && curC <= startC + L){
                        cnt++;
                    }
                }
                maxCnt = Math.max(maxCnt,cnt);
            }
        }
        System.out.println(K-maxCnt);
    }
}
