package 우선순위큐;
import java.util.*;
public class pg_디펜스게임 {

    class Solution {
        public int solution(int n, int k, int[] enemy) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            if(k >= enemy.length){
                return enemy.length;
            }

            for(int i = 0; i < k; i++){
                pq.add(enemy[i]);
            }
            int sum = 0;
            int ans = 0;
            for(int i = k; i < enemy.length; i++){
                if(pq.peek() >= enemy[i]){
                    sum += enemy[i];
                }
                else{
                    int first = pq.poll();
                    pq.add(enemy[i]);
                    sum += first;
                }
                if(sum > n){
                    ans = i;
                    break;
                }
            }
            if(ans == 0){
                return enemy.length;
            }
            return ans;

        }
    }
}
