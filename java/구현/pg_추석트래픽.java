package 구현;

import java.util.ArrayList;

public class pg_추석트래픽 {
    class Solution {

        public int solution(String[] lines) {
            ArrayList<int[]> list = new ArrayList<>();
            for(String s : lines){
                String[] parseString = s.split(" ");
                String secString = parseString[2];
                int milisec = (int)(Float.parseFloat(secString.substring(0,secString.length()-1)) * 1000);
                int endTime = inputToMiliSec(parseString[1]);
                int[] StoE = new int[2];
                StoE[0] = endTime - milisec + 1;
                StoE[1] = endTime;
                System.out.println(StoE[0] + " " + StoE[1]);

                list.add(StoE);
            }
            int max = 1;
            for(int i = 0; i < list.size(); i++){
                int cnt = 1;
                int[] beforeStoE = list.get(i);
                for(int j = i + 1; j < list.size(); j++){
                    if(beforeStoE[1] + 1000 > list.get(j)[0]){
                        cnt++;
                    }
                }
                if (max < cnt){
                    max = cnt;
                }
            }
            return max;
        }
        static int inputToMiliSec(String s){
            int answer = 0;
            String[] str = s.split(":");
            answer += Integer.parseInt(str[0]) * 60 * 60 * 1000;
            answer += Integer.parseInt(str[1]) * 60 * 1000;
            answer += (int)((Float.parseFloat(str[2]) * 10000) / 10); // 이상함
            System.out.println((int)(Float.parseFloat(str[2]) * 1000));
            return answer;
        }
    }
}
