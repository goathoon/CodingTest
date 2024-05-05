package 브루트포스;

import java.io.*;
import java.util.regex.Pattern;

public class boj_1013 {
    class Solution1 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            String inputs;
            for (int n = 0; n < N; n++) {
                inputs = br.readLine();
                String res = Pattern.matches("(100+1+|01)+", inputs) ? "YES" : "NO";
                System.out.println(res);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            String s = br.readLine();
            int nextIdx = 0;
            boolean possible = true;
            while (true) {
                if(s.charAt(nextIdx) == '0'){
                    nextIdx = checkZero(s,nextIdx);
                }
                else{
                    nextIdx = checkOne(s,nextIdx);
                }
                if(nextIdx == -1){
                    possible = false;
                    break;
                }
                if(nextIdx >= s.length()) break;
            }
            if(possible) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static int checkZero(String s, int idx){
        if(s.length() <= idx+1) return -1;
        if(s.charAt(idx+1) == '0'){
            if(idx-2 >= 0 && s.charAt(idx-1) == '1' && s.charAt(idx-2) == '1' ){
                return idx-1;
            }
            return -1;
        }
        if(s.charAt(idx+1) == '1') return idx+2;
        return -1;
    }
    public static int checkOne(String s, int idx){

        if(s.length() <= idx+3) return -1;
        if(s.charAt(++idx) == '0' && s.charAt(++idx) == '0'){
            boolean end = false;
            while(true){
                ++idx;
//                System.out.println("now idx = " + idx);
                if(idx >= s.length()){
                    if(end) return idx;
                    return -1;
                }
                if (end && s.charAt(idx) == '0') {
                    return idx;
                }
                else if(s.charAt(idx) == '1'){
                    end = true;
                }
            }
        }
        return -1;
    }
}
