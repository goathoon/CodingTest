package 그리디;

import java.io.*;
import java.util.Arrays;

public class boj_2138 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer total = Integer.parseInt(br.readLine());
        char[] from =  br.readLine().toCharArray();
        char[] copyFrom = new char[total];
        System.arraycopy(from,0,copyFrom,0,from.length);
        char[] to =  br.readLine().toCharArray();

        // 첫번째 전구를 다짜고짜 누르고 시작
        toggle(copyFrom,0);
        toggle(copyFrom,1);
        int aCnt = 1 + getCountOfSwitching(copyFrom,to);
        // 첫번째 전구를 안누르고 시작
        int bCnt = getCountOfSwitching(from,to);
        if ( Math.min(aCnt,bCnt) >= Integer.MAX_VALUE -1) {
            System.out.println(-1);
        }
        else{
            System.out.println(Math.min(aCnt,bCnt));
        }

    }
    private static void toggle(char[] array, int idx){
        array[idx] = array[idx] == '0'? '1' : '0';
    }

    private static int getCountOfSwitching(char[] array, char[] to){
        int cnt = 0;
        for (int idx = 1; idx < array.length-1; idx ++){
            if(array[idx-1] != to[idx-1]){
                toggle(array,idx-1);
                toggle(array,idx);
                toggle(array,idx+1);
                cnt ++;
            }
        }
        if (array[array.length-2] != to[array.length-2]){
            toggle(array,array.length-2);
            toggle(array,array.length-1);
            cnt ++;
        }
        if(array[array.length-1] != to[array.length-1]) {
            cnt = Integer.MAX_VALUE - 1;
        }
        return cnt;
    }

}
