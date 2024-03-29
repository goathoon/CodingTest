package 구현;
import java.util.*;
public class pg_풍선터트리기 {

    class Solution {
        public int solution(int[] a) {
            int answer = a.length ;
            if (a.length == 3) return 3;
            int[] leftMin = new int[a.length];
            int[] rightMin = new int[a.length];
            leftMin[0] = a[0];
            rightMin[a.length-1] = a[a.length-1];
            for(int i = 1; i < a.length; i ++){
                leftMin[i] = Math.min(leftMin[i-1],a[i]);
            }
            for(int i = a.length-2; i >= 0; i--){
                rightMin[i] = Math.min(rightMin[i+1],a[i]);
            }

            for(int i = 1; i < a.length-1; i ++){
                if(a[i] > leftMin[i-1] && a[i] > rightMin[i+1]){
                    answer--;
                }
            }
            return answer;
        }
    }
}
