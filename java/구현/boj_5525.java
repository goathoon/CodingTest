package 구현;

import java.io.*;

public class boj_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int start = 0;
        int cnt = 0;
        int ans = 0;
        while(start < M-2){
            if(s.substring(start,start+3).equals("IOI")){
                cnt++;
                if(cnt == N) {
                    ans++;
                    cnt--;
                }
                start += 2;
            }
            else {
                start++;
                cnt = 0;
            }
        }

        System.out.println(ans);
    }
}
