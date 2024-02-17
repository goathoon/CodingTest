package 우선순위큐;
import java.util.*;

/**
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 *
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 *
 * While moving from building i to building i+1 (0-indexed),
 *
 * If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 */

public class leet_1642 {
    class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for(int i = 0; i < heights.length - 1; i++){
                int h = heights[i+1] - heights[i];
                if(h > 0){
                    bricks -= h;
                    pq.add(h);
                    if(bricks < 0){
                        if(ladders <= 0){
                            return i;
                        }
                        int add = pq.poll();
                        ladders -= 1;
                        bricks += add;
                    }
                }
            }
            return heights.length - 1;
        }
    }
    // 아래 풀이를 하면서 (dp top-down 방식임), memoization을 활용하면 무조건 Memory Limit이 걸릴것으로 생각하고 다른 방식을 고려하였다. 그래서 참고한것이 PQ방식이다.
    class Solution2 {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            return dfs(0,heights,bricks,ladders);
        }
        public int dfs(int idx, int[] heights, int bricks, int ladders){
            int res = 0;
            if(idx == heights.length-1) return idx;

            if(heights[idx] < heights[idx+1]){
                int h = heights[idx+1] - heights[idx];
                if(h <= bricks) res = Math.max(dfs(idx+1, heights, bricks-h, ladders), res);
                if(ladders > 0) res = Math.max(dfs(idx+1, heights, bricks, ladders-1), res);
                if(h > bricks && ladders <= 0) return idx;
            }
            else{
                return dfs(idx+1, heights, bricks, ladders);
            }
            return res;
        }
    }
}
