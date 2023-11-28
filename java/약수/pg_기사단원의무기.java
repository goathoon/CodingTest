package 약수;

import java.util.stream.IntStream;

class pg_기사단원의무기 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] numbers = IntStream.rangeClosed(1,number).toArray();
        for(int n:numbers){
            int cnt = getCntDivisor(n) ;
            if (cnt> limit){
                answer += power;
            }
            else{
                answer += cnt;
            }
                
        }
        return answer;
    }
    public static int getCntDivisor(int n){
        int cnt = 0;
        for (int i = 1; i <= (int)Math.sqrt(n); i++){
            if (n % i == 0) {
                if (n/i ==i) cnt ++;
                else cnt += 2;
            }
        }
        return cnt;
    }
}

