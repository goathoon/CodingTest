package 구현;

import java.io.*;
public class boj_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Integer index = Integer.parseInt(br.readLine());
        System.out.print(s.charAt(index-1));
    }
}
