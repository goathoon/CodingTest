package 구현;
import java.io.*;
import java.util.*;
public class EX_시각2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int time = (N+1)*60*60;
        int t = 0;
        int ans = 0;
        while(t < time){
            if(isThree(t++)){
                ans++;
            }
        }
        System.out.println(ans);
    }
    public static boolean isThree(int t){
        int hour = t / 3600;
        int min = (t % 3600) / 60;
        int sec = t % 60;
        if(hour % 10 == 3 || min / 10 == 3 || min % 10 == 3 || sec / 10 == 3 || sec % 10 == 3) return true;
        return false;
    }
}
