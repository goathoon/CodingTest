package 브루트포스;
import java.io.*;
import java.util.*;
public class boj_2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> strings = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            if(strings.contains(s)) continue;
            strings.add(s);
        }

        int a = 0;
        int b = 0;
        int max = 0;

        for(int i = 0; i < N-1; i++){
            String s1 = strings.get(i);
            for(int j = i+1; j < N; j++){
                String s2 = strings.get(j);
                int cnt = 0;
                int len = s1.length() < s2.length()? s1.length() : s2.length();
                for(int k = 0; k < len; k++){
                    if(s1.charAt(k) != s2.charAt(k)){
                        break;
                    }
                    cnt++;
                }
                if(max < cnt){
                    max = cnt;
                    a = i;
                    b = j;
                }
            }
        }
        System.out.println(strings.get(a));
        System.out.println(strings.get(b));

    }
}
