package 백트래킹;

import java.util.Scanner;

public class swea_1244 {
    static int answer = 0;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        char[] numbers;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            numbers = sc.next().toCharArray();
            int cnt = sc.nextInt();

            // 최적화 부분
            if(numbers.length < cnt){
                cnt = numbers.length;
            }

            changeNumberArray(numbers,0,cnt);
            System.out.printf("#%d %d",test_case,answer);
            System.out.println();
            answer = 0;
        }
    }
    static void changeNumberArray(char[] arr, int curDepth, int depth){
        if(curDepth == depth){
            int  result = 0;
            int x = 1;
            for(int i = arr.length - 1; i >= 0; i--){
                result += Character.getNumericValue(arr[i]) * x;
                x *= 10;
            }

            answer = Math.max(answer,result);
            return;
        }

        for(int i = 0 ; i < arr.length; i ++){
            for(int j = i+1; j < arr.length; j ++){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                changeNumberArray(arr,curDepth+1,depth);
                arr[j] =arr[i];
                arr[i] = temp;
            }
        }
    }
}
