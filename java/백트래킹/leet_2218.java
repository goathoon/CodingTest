package 백트래킹;
import java.util.*;
public class leet_2218 {

    // 특정 pile 포지션에서 같은 coin의 개수가 남은 경우에 memoization 기법으로 캐싱함
    class Solution {
        static int[][] memo;
        public int maxValueOfCoins(List<List<Integer>> piles, int k) {
            memo = new int[piles.size() + 1][2001];
            for(int i = 0; i <piles.size() + 1; i++){
                for(int j = 0; j < 2001; j ++){
                    memo[i][j] = -1;
                }
            }
            return dfs(0,k,piles);
        }
        static int dfs(int pileIdx, int coins, List<List<Integer>> piles){
            if(pileIdx == piles.size()) return 0;

            if(memo[pileIdx][coins] != -1){
                return memo[pileIdx][coins];
            }
            // 해당 pile에서 아무 coin도 뽑지 않을 경우
            memo[pileIdx][coins] = dfs(pileIdx + 1, coins, piles);

            // 해당 pile에서 coin을 1개부터 끝까지 뽑을 경우
            int maxIter = piles.get(pileIdx).size();
            int curCoin = 0;
            for(int i = 0; i < Math.min(maxIter, coins); i ++){
                curCoin += piles.get(pileIdx).get(i);
                memo[pileIdx][coins] = Math.max(memo[pileIdx][coins], curCoin + dfs(pileIdx + 1, coins-i-1, piles));
            }
            return memo[pileIdx][coins];
        }
    }
}
