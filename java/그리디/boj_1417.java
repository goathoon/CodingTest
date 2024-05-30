package 그리디;

import java.io.*;
import java.util.*;

public class boj_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N-1];
        for(int i = 1; i < N; i++){
            arr[i - 1] = Integer.parseInt(br.readLine());
        }
        if(N == 1){
            System.out.println(0);
            System.exit(0);
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        int ans = 0;
        while(target <= arr[0]){
            arr[0] -= 1;
            target += 1;
            ans++;
            Arrays.sort(arr, Comparator.reverseOrder());
        }
        System.out.println(ans);
    }

    class ListSol{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int target = Integer.parseInt(br.readLine());
            List<Integer> people = new ArrayList<>();
            for(int i = 1; i < N; i++){
                people.add(Integer.parseInt(br.readLine()));
            }
            if(N == 1){
                System.out.println(0);
                System.exit(0);
            }
            Collections.sort(people, Comparator.reverseOrder());
            int ans = 0;
            while(target <= people.get(0)){
                people.set(0,people.get(0)-1);
                target += 1;
                ans++;
                Collections.sort(people, Comparator.reverseOrder());
            }
            System.out.println(ans);
        }
    }
}
