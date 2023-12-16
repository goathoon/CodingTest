package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14888 {
    static long maxAnswer = -1_000_000_001L;
    static long minAnswer = 1_000_000_001L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = Integer.parseInt(br.readLine());
        int[] nums = new int[cnt];
        int[] ops = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < cnt; i ++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++){
            ops[i] = Integer.parseInt(st.nextToken());
        }
        backTracking(nums,ops,0,0,0);
        System.out.println(maxAnswer);
        System.out.println(minAnswer);

    }
    static void backTracking(int[] nums, int[] ops,int startIdx,long candAnswer,int depth){

        if(depth == nums.length-1){
            maxAnswer = Math.max(candAnswer,maxAnswer);
            minAnswer = Math.min(candAnswer, minAnswer);
            return;
        }
        for(int i = startIdx; i < nums.length; i++){
            if(i ==1 ) continue;
            for(int j = 0; j < 4; j++){
                boolean isFirst = false;
                // + - * /
                if (ops[j] > 0){
                    ops[j] -= 1;
                    long nextAnswer = 0L;
                    switch(j){
                        case 0: {
                            if (i ==0){
                                nextAnswer = nums[i] + nums[i+1];
                                isFirst = true;
                            }
                            else{
                                nextAnswer = candAnswer + nums[i];
                            }
                            break;
                        }
                        case 1 :{
                            if (i == 0) {
                                nextAnswer = nums[i] - nums[i + 1];
                                isFirst = true;
                            }
                            else{
                                nextAnswer = candAnswer - nums[i];
                            }
                            break;
                        }
                        case 2 : {
                            if(i==0){
                                nextAnswer = nums[i] * nums[i+1];
                                isFirst = true;
                            }
                            else{
                                nextAnswer = candAnswer * nums[i];
                            }
                            break;
                        }
                        case 3 :{
                          if(i==0){
                              if(nums[i+1] == 0) return;
                              nextAnswer = nums[i] / nums[i+1];
                              isFirst = true;
                          }
                          else{
                              if(nums[i] == 0) return;
                              nextAnswer = candAnswer / nums[i];
                          }
                          break;
                        }
                    }
                    if (isFirst){
                        backTracking(nums,ops,i+2,nextAnswer,depth+1);
                        ops[j] += 1;
                    }
                    else {
                        backTracking(nums, ops, i + 1, nextAnswer, depth + 1);
                        ops[j] += 1;
                    }
                }
            }
        }
    }
}
