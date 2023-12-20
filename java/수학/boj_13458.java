package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] places = new int[cnt];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < cnt; i++){
            places[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int common = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());

        long answer = cnt;
        for(int i = 0; i < cnt; i++){
            int subCnt = 0;
            if(places[i] > common){
                if ((places[i] - common) % sub == 0){
                    subCnt += (places[i] - common) / sub;
                }
                else{
                    subCnt += (places[i] - common) / sub + 1;
                }
            }
            else continue;
            answer += subCnt;
        }
        System.out.println(answer);
    }
}
