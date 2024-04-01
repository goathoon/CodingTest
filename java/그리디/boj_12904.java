package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class boj_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String e = br.readLine();
        while(s.length() != e.length()){
            if(e.charAt(e.length()-1) == 'A'){
                e = e.substring(0,e.length()-1);
            }
            else{
                e = reverseString(e.substring(0,e.length()-1));
            }
        }
        if(s.equals(e)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }

    }
    public static String reverseString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
