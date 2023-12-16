package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14888_깔끔 {
    static long maxAnswer = -1_000_000_001L;
    static long minAnswer = 1_000_000_001L;
    static int cnt;
    static int[] nums;
    static int[] ops;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        cnt = Integer.parseInt(br.readLine());
        nums = new int[cnt];
        ops = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < cnt; i ++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++){
            ops[i] = Integer.parseInt(st.nextToken());
        }
        backTracking(nums[0],0);
        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }
    static void backTracking(int num, int target){
        if(target == cnt-1){
            maxAnswer = Math.max(num,maxAnswer);
            minAnswer = Math.min(num,minAnswer);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(ops[i] > 0) {
                ops[i] -= 1;
                switch (i) {
                    case 0:
                        backTracking(num + nums[target + 1], target + 1);
                        break;
                    case 1:
                        backTracking(num - nums[target + 1], target + 1);
                        break;
                    case 2:
                        backTracking(num * nums[target + 1], target + 1);
                        break;
                    case 3:
                        backTracking(num / nums[target + 1], target + 1);
                        break;
                }
                ops[i] ++;
            }

        }
    }
}
