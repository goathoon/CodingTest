package 그리디;
import java.util.*;
import java.io.*;

class boj_1439{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 0;
        boolean doing = false;
        char c = s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            if(c != s.charAt(i)){
                if(!doing){
                    cnt++;
                    doing = true;
                }
            }
            else{
                doing = false;
            }
        }
        System.out.println(cnt);
    }
}