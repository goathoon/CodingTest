package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class boj_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int zeroCnt = 0;
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0) plus.add(num);
            else if(num < 0) minus.add(num);
            else zeroCnt ++;
        }
        Collections.sort(plus, Comparator.reverseOrder());
        Collections.sort(minus);
        int plusCnt = plus.size();
        int minusCnt = minus.size();
        int plusIdx = 0;
        int minusIdx = 0;
        int answer = 0;
        while(plusCnt  >= 2){
            if(plus.get(plusIdx) * plus.get(plusIdx+1) > plus.get(plusIdx) + plus.get(plusIdx+1)){
                answer += plus.get(plusIdx) * plus.get(plusIdx+1);
            }else{
                answer += plus.get(plusIdx) + plus.get(plusIdx+1);
            }
            plusIdx += 2;
            plusCnt -= 2;
        }
        if(plusCnt == 1){
            answer += plus.get(plusIdx);
        }


        while(minusCnt >= 2){
            answer += minus.get(minusIdx) * minus.get(minusIdx+1);
            minusIdx += 2;
            minusCnt -= 2;
        }
        if(minusCnt == 1){
            if(zeroCnt == 0){
                answer += minus.get(minusIdx);
            }
        }
        System.out.println(answer);
    }
}
