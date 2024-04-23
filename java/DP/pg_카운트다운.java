package DP;
import java.util.*;
public class pg_카운트다운 {

    class Solution {
        static int[][] dp;
        public int[] solution(int target) {
            dp = new int[target+1][2];
            for(int i = 0; i < dp.length; i++){
                dp[i][0] = Integer.MAX_VALUE;
            }
            dp[0][0] = 0;
            for(int t = 1; t <= target; t++){
                // 유효한 점수 내에서 볼 맞출 경우
                if(t-50 >= 0){
                    if(dp[t][0] > dp[t-50][0]+1){
                        dp[t][0] = dp[t-50][0]+1;
                        dp[t][1] = dp[t-50][1]+1;
                    }
                    else if(dp[t-50][0]+1 == dp[t][0]){
                        dp[t][1] = Math.max(dp[t-50][1]+1,dp[t][1]);
                    }
                }
                for(int j = 1; j <= 20; j++){
                    if(t-j >= 0){
                        if(dp[t][0] > dp[t-j][0]+1){
                            dp[t][0] = dp[t-j][0]+1;
                            dp[t][1] = dp[t-j][1]+1;
                        }
                        else if(dp[t-j][0]+1 == dp[t][0]){
                            dp[t][1] = Math.max(dp[t-j][1]+1,dp[t][1]);
                        }

                    }
                    if(t-2*j >= 0){
                        if(dp[t][0] > dp[t-2*j][0]+1){
                            dp[t][0] = dp[t-2*j][0]+1;
                            dp[t][1] = dp[t-2*j][1];
                        }
                        else if(dp[t-2*j][0]+1 == dp[t][0]){
                            dp[t][1] = Math.max(dp[t-2*j][1],dp[t][1]);
                        }
                    }
                    if(t-3*j >= 0){
                        if(dp[t][0] > dp[t-3*j][0]+1){
                            dp[t][0] = dp[t-3*j][0]+1;
                            dp[t][1] = dp[t-3*j][1];
                        }
                        else if(dp[t-3*j][0]+1 == dp[t][0]){
                            dp[t][1] = Math.max(dp[t-3*j][1],dp[t][1]);
                        }

                    }
                }
            }
            int[] answer = new int[2];
            answer[0] = dp[target][0];
            answer[1] = dp[target][1];
            return answer;
        }
    }


}
