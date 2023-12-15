package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15666_arr풀이 {
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        result = new int[m];
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i <n; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutations(arr,0,0,m);
    }
    static void permutations(int[] arr, int startIdx, int cnt, int target){
        if(cnt==target){
            for(int i = 0; i< target; i++){
                System.out.printf("%d ", result[i]);
            }
            System.out.println();
            return;
        }
        int before = -1;
        //해당 레벨(n개 뽑은 상태)에서 추가적으로 뽑는 수의 중복을 제거하기 위한 before 변수 선언
        for(int i = startIdx; i < arr.length; i ++){
            if(before != arr[i]){
                //이전에 arr[i]를 뽑지 않았을 경우에
                before = arr[i];
                result[cnt] = arr[i];
                permutations(arr,i,cnt+1,target);
            }

        }
    }
}
