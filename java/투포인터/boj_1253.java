package 투포인터;

import java.io.*;
import java.util.*;
public class boj_1253 {
    class Main{
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int ans = 0;
            for(int i = 0; i < arr.length; i++){
                int l = 0;
                int r = arr.length-1;
                while(l < r){
                    if(l == i) {
                        l++;
                        continue;
                    }
                    if(r == i) {
                        r--;
                        continue;
                    }

                    if(arr[i] == arr[l] + arr[r]) {
                        ans++;
                        break;
                    }
                    else if (arr[i] > arr[l] + arr[r]){
                        l++;
                    }
                    else if (arr[i] < arr[l] + arr[r]){
                        r--;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
