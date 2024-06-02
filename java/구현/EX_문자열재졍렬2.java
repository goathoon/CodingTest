package 구현;
import java.io.*;
import java.util.*;
public class EX_문자열재졍렬2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int num = 0;
        for(int i = 0; i <arr.length; i++){
            if(Character.isLetter(arr[i])){
                sb.append(arr[i]);
            }
            else if (Character.isDigit(arr[i])){
                num += Character.getNumericValue(arr[i]);
            }
        }
        if(num != 0) {
            sb.append(num);
        }
        System.out.println(sb);
    }
}
