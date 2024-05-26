package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class EX_문자열재졍렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = "";
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            // Character.isLetter() 가능
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                num += Character.getNumericValue(s.charAt(i));
            }
            else{
                ans += s.charAt(i);
            }
        }
        char[] cs = ans.toCharArray();
        Arrays.sort(cs);
        StringBuilder sb = new StringBuilder();
        sb.append(cs).append(num);
        System.out.println(sb);
    }
}
