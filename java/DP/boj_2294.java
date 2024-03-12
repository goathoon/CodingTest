package DP;
import java.io.*;
import java.util.*;
public class boj_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k+1];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(Integer.parseInt(br.readLine()));
        }
        List<Integer> sortSet = new ArrayList<>(set);
        for(int i = 1 ; i < arr.length; i++){
            for(int x : sortSet){
                if(i == x){
                    arr[i] = 1;
                }
                else if (i > x){
                    if(arr[i-x] > 0){
                        if(arr[i] > 0){
                            arr[i] = Math.min(arr[i-x]+1,arr[i]);
                        }
                        else{
                            arr[i] = arr[i-x] + 1;
                        }
                    }
                }
            }
        }
        if(arr[k] == 0){
            System.out.println(-1);
            System.exit(0);
        }
        System.out.println(arr[k]);
    }

}
