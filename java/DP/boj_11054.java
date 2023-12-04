package DP;
import java.io.*;
import java.util.StringTokenizer;

public class boj_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        int[] increasingDP = new int[len];
        int[] decreasingDP = new int[len];
        int[] answerDP = new int[len];
        for (int i = 0; i <len; i++){
            increasingDP[i] = decreasingDP[i] = 1;
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<len; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if (arr[j] > arr[i] && increasingDP[j] < increasingDP[i] + 1){
                    increasingDP[j] = increasingDP[i] + 1;
                }
            }
        }

        for (int i = len - 1; i > 0; i--){
            for (int j = i + 1; j < len; j++){
                if (arr[i] > arr[j] && decreasingDP[i] < decreasingDP[j] + 1){
                    decreasingDP[i] = decreasingDP[j] + 1;
                }
            }
        }

        int answer = 1;
        for (int i = 0 ; i < len; i++){
            answerDP[i] = increasingDP[i] + decreasingDP[i] - 1;
            answer = Math.max(answer,answerDP[i]);

        }
        System.out.println(answer);
    }
}
