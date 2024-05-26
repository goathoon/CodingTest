package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX_시각 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int h = 0; h <= N; h++){
            for(int m = 0; m < 60; m++){
                for(int s = 0; s < 60; s++){
                    if(check(h,m,s)){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static boolean check(int h, int m, int s){
        if(h % 10 == 3 || m / 10 == 3  || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) return true;
        return false;
    }
    class MySol {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int time = 0;
            int ans = 0;
            while (time <= (N + 1) * 3600 - 1) {
                int hour = time / 3600;
                int min = (time % 3600) / 60;
                int sec = (time % 3600) % 60;

                if (isThree(String.valueOf(hour)) || isThree(String.valueOf(min)) || isThree(String.valueOf(sec))) {
                    ans++;
                }
                time++;
            }
            System.out.println(ans);
        }

        public static boolean isThree(String s) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '3') {
                    return true;
                }
            }
            return false;
        }
    }
}
