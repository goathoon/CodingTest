package 그리디;
import java.io.*;
import java.util.*;
public class boj_11509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int n = 0; n < arr.length; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        Map<Integer,Integer> targets = new HashMap<>();
        for(int h = 1; h <= 1_000_000; h++){
            targets.put(h,0);
        }

        int ans = 0;
        for(int n = 0; n < arr.length; n++){
            if(targets.get(arr[n]) >= 1) {
                targets.compute(arr[n],(k,v)-> v-1);
                if(arr[n]-1 == 0){
                    continue;
                }
                targets.compute(arr[n]-1,(k,v)->v+1);
            }
            else{
                ans++;
                if(arr[n]-1 == 0){
                    continue;
                }
                targets.compute(arr[n]-1,(k,v)->v+1);
            }
        }
        System.out.println(ans);
    }
}
