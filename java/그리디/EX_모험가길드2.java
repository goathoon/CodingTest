package 그리디;
import java.io.*;
import java.util.*;

public class EX_모험가길드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < people.length; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(people);

        int ans = 0;
        int sum = 0;
        for(int i = 0; i < people.length; i++){
            sum ++;
            if(people[i] <= sum){
                ans ++;
                sum = 0;
            }
        }
        System.out.println(ans);
    }
}
