package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int curLen = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int maxLen = Integer.parseInt(st.nextToken());

        if(curLen == 0) {
            System.out.println(1);
            return;
        }

        int[] list = new int[curLen];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < curLen; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        boolean isSame = false;
        int sameRank = -1;
        if(curLen < maxLen){
            for(int i = 0; i < curLen; i++){
                if(list[i] <= score){
                    System.out.println(i+1);
                    return;
                }
            }
            System.out.println(curLen+1);
        }

        //꽉 차있을 경우

        else {
            for(int i = 0; i < curLen; i++){
                if(list[i] == score) {
                    if(isSame) continue;
                    isSame = true;
                    sameRank = i+1;
                }
                if(list[i] < score){
                    if(!isSame) System.out.println(i+1);
                    else System.out.println(sameRank);
                    return;
                }
            }
            System.out.println(-1);
        }
    }
}
