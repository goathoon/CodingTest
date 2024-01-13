package 구간합;
import java.util.*;
public class pg_광고삽입 {
    class Solution {
        final static int MAX_TIME = 60*60*100;

        public String solution(String play_time, String adv_time, String[] logs) {
            long[] memo = new long[MAX_TIME + 1];
            for(String log : logs){
                String[] startToEnd = log.split("-");
                int startTime = parseToSec(startToEnd[0]);
                int endTime = parseToSec(startToEnd[1]);
                memo[startTime] += 1;
                memo[endTime] -= 1;

            }

            //구간합 - 누적 시청자 수
            for(int t = 1; t < MAX_TIME + 1 ; t++){
                memo[t] += memo[t-1];
            }
            //구간합 - 누적 재생 횟수
            for(int t = 1; t < MAX_TIME ; t ++){
                memo[t] += memo[t-1];
            }
            int advTime = parseToSec(adv_time);
            long maxVal = 0;
            int resultInt = 0;
            for(int t = 0 ; t < MAX_TIME - advTime; t ++){
                if (maxVal < memo[t + advTime] - memo[t]){
                    maxVal = memo[t+advTime] - memo[t];
                    resultInt = t;
                }
            }
            if(resultInt == 0){
                return "00:00:00";
            }
            return parseSecToString(resultInt+1);
        }

        static int parseToSec(String time){
            String[] arr = time.split(":");
            return Integer.parseInt(arr[0]) * 3600 + Integer.parseInt(arr[1]) * 60 + Integer.parseInt(arr[2]);
        }

        static String parseSecToString(int time){
            StringBuilder sb = new StringBuilder();

            int hour = time / 3600;
            int min = (time % 3600) / 60;
            int sec = (time % 3600) % 60;

            if (hour == 0){
                sb.append("00");
            }
            else if (0 < hour && hour < 10){
                sb.append("0");
                sb.append(hour);
            }
            else{
                sb.append(hour);
            }
            sb.append(":");

            if (min == 0){
                sb.append("00");
            }
            else if (0 < min && min < 10){
                sb.append("0");
                sb.append(min);
            }
            else{
                sb.append(min);
            }
            sb.append(":");

            if (sec == 0){
                sb.append("00");
            }
            else if (0 < sec && sec < 10){
                sb.append("0");
                sb.append(sec);
            }
            else{
                sb.append(sec);
            }
            return sb.toString();
        }


    }
}
