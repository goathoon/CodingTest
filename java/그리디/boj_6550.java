package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class boj_6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Loop1 : while(true) {
            String tcString = br.readLine();
            if(Objects.isNull(tcString)) return;

            st = new StringTokenizer(tcString, " ");
            char[] s = st.nextToken().toCharArray();
            char[] t = st.nextToken().toCharArray();
            int tIdx = 0;
            Loop2 : for(int i = 0; i < s.length; i++){
                char charCompared = s[i];
                while(tIdx < t.length){
                    if(charCompared == t[tIdx++]) continue Loop2;
                }
                System.out.println("No");
                continue Loop1;
            }
            System.out.println("Yes");
        }

    }
}
