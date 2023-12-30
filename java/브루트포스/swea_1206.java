package 브루트포스;

import java.util.Scanner;

public class swea_1206 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int cnt = sc.nextInt();
            int[] arr = new int[cnt];
            for(int i = 0; i < cnt; i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 2; i < cnt -2; i++){
                for(int f = 1; f <= arr[i]; f++){
                    if(arr[i-1] >= f || arr[i-2] >= f || arr[i+1] >= f || arr[i+2] >= f) continue;
                    ans++;
                }
            }
            System.out.printf("#%d %d",test_case, ans);
            System.out.println();
            ans = 0;
        }
    }
}
