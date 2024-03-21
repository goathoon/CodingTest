package 이분탐색;

public class pg_징검다리건너기 {
    class Solution {
        public int solution(int[] stones, int k) {
            long l = 0;
            long r = Integer.MAX_VALUE;
            while(l < r){
                long m = (l+r)/2;
                int cnt = 0;
                int maxCnt = 0;
                for(int s : stones){
                    if (s-m <= 0){
                        cnt++;
                    }
                    else {
                        maxCnt= Math.max(maxCnt,cnt);
                        cnt = 0;
                    }
                }

                maxCnt= Math.max(maxCnt,cnt);

                if(maxCnt < k){
                    l = m+1;
                }
                else{
                    r = m;
                }
            }
            return (int)l;
        }

    }
}
