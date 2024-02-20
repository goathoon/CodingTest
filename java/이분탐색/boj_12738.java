package 이분탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_12738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            int listCnt = list.size();
            if(arr[i] > list.get(listCnt-1)){
                list.add(arr[i]);
            }
            else{
                int l = 0, r = listCnt-1;
                int m = (l+r)/2;
                while(l < r){
                    m = (l+r)/2;
                    if(arr[i] > list.get(m)){
                        l = m+1;
                    }
                    else if (arr[i] == list.get(m)){
                        break;
                    }
                    else{
                        r = m;
                    }
                }
                list.set((l+r)/2,arr[i]);
            }
        }
        System.out.println(list.size());
    }
}
