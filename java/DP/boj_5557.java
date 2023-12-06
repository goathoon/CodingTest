package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        Map<Integer, Long>[] dp = new Map[length];
        int[] arr = new int[length];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = new HashMap<>();
        }
        //예외적으로 첫 번째 Map원소에는 배열 한개만 들어감
        dp[0].put(arr[0], 0L);
        for (int i = 1; i < length - 1; i++) {
            for(int key : dp[i-1].keySet()){
                Long value = dp[i-1].get(key) == 0 ? 1 : dp[i-1].get(key);

                if(key + arr[i] >= 0 && key + arr[i] <= 20){
                    if (dp[i].containsKey(key+arr[i])){
                        dp[i].put(key + arr[i],dp[i].get(key+arr[i]) + value);
                    }
                    else{
                        dp[i].put(key + arr[i],value);
                    }
                }
                if (key - arr[i] >=0 && key - arr[i] <= 20){
                    if (dp[i].containsKey(key-arr[i])){
                        dp[i].put(key - arr[i],dp[i].get(key-arr[i]) + value);
                    }
                    else{
                        dp[i].put(key - arr[i],value);
                    }
                }
            }
        }
        for (int key : dp[length-2].keySet()){
            if (key == arr[length-1]){
                System.out.println(dp[length-2].get(key));
            }
        }

    }
}
