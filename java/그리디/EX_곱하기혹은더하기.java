package 그리디;
import java.io.*;
import java.util.*;
public class EX_곱하기혹은더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cur = Character.getNumericValue(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(cur + s.charAt(i) > cur * s.charAt(i)){
                cur = cur + Character.getNumericValue(s.charAt(i));
            }else{
                cur = cur * Character.getNumericValue(s.charAt(i));
            }
        }
        System.out.println(cur);
    }
}
