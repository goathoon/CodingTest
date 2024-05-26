package 구현;
import java.io.*;
import java.util.*;
public class EX_왕실의나이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int row = Character.getNumericValue(s.charAt(1));
        int col = s.charAt(0) - 'a' + 1;

        int[] drow = {-2,-1,1,2,2,1,-1,-2};
        int[] dcol = {1,2,2,1,-1,-2,-2,-1};

        int ans = 0;
        for(int i = 0; i < 8; i++){
            if(row + drow[i] >= 1 && row + drow[i] <= 8 && col + dcol[i] >= 1 && col + dcol[i] <= 8){
                ans ++;
            }
        }
        System.out.println(ans);
    }
}
