package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_15666 {
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        result = new int[m];
        Set<Integer> s = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i <n; i ++){
            s.add(Integer.parseInt(st.nextToken()));
        }
        Integer[] arr = s.toArray(new Integer[0]);
        Arrays.sort(arr);
        permutation(arr,0,m);
    }
    static void permutation(Integer[] arr, int depth, int target){
        if (depth == target){
            for (int i = 0; i< target;i ++){
                System.out.printf("%d ", result[i]);
            }
            System.out.println();
            return;
        }
        for(int x : arr){
            if(depth > 0){
                if (result[depth-1] > x) continue;
            }
            result[depth] = x;
            permutation(arr,depth+1,target);
        }
    }
}
