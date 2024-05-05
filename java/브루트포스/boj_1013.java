package 브루트포스;

import java.io.*;
import java.util.regex.Pattern;

public class boj_1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String inputs;
        for(int n = 0; n < N; n++){
            inputs = br.readLine();
            String res = Pattern.matches("(100+1+|01)+",inputs) ? "YES" : "NO";
            System.out.println(res);
        }
    }

}
