package DP;

public class pg_연속펄부분수열의합 {
    class Solution {
        public long solution(int[] sequence) {
            int ans = 0;
            int[] plus = new int[sequence.length];
            int[] minus = new int[sequence.length];
            int p = 1;
            int m = -1;
            for(int i = 0; i < sequence.length; i++){
                plus[i] = sequence[i] * p;
                minus[i] = sequence[i] * m;
                p*=-1;
                m*=-1;
            }
            long[] dpA = new long[sequence.length+1];
            long[] dpB = new long[sequence.length+1];
            long maxA = 0;
            long maxB = 0;
            for(int i = 0; i < sequence.length; i++){
                dpA[i+1] = Math.max(dpA[i]+plus[i],dpA[i+1]);
                maxA = Math.max(dpA[i+1],maxA);
                dpB[i+1] = Math.max(dpB[i]+minus[i],dpB[i+1]);
                maxB = Math.max(dpB[i+1],maxB);
            }
            return Math.max(maxA,maxB);

        }
    }
}
