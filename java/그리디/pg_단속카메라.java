package 그리디;
import java.util.*;
public class pg_단속카메라 {

    class Solution {
        public int solution(int[][] routes) {
            Arrays.sort(routes,(r1,r2)->r1[1]-r2[1]);
            int i = 0;
            int answer = 0;
            while(true){
                //마지막 전출 지점에서 routes다 돌면서 그것보다 큰 진입지점이면 해당 route의 전출지점으로 재탐색
                int curLast = routes[i][1];
                answer++;
                int j = i+1;
                while(j < routes.length){
                    if(curLast < routes[j][0]){
                        i = j;
                        break;
                    }
                    j++;
                }
                if(j==routes.length) return answer;
            }
        }
    }
}
