import java.io.*;
import java.util.*;

public class boj_18110 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        int[] scores = new int[tc];
        if (tc == 0){
            System.out.println(0);
            return;
        }
        for(int i = 0; i<tc; i++){
            scores[i] = Integer.parseInt(bf.readLine());
        }
        int except = Math.round(tc*0.15f);
        Arrays.sort(scores);
        int sum = 0;
        for(int i = except; i < tc - except; i++){
            sum += scores[i];
        }
        System.out.println(Math.round((float)sum/(tc- 2*except)));
    }

}
