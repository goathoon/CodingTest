package 구현;
import java.io.*;
import java.util.*;
public class boj_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < 3; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            if(arr[2] == 0) break;

            if(arr[2] >= arr[0]+arr[1]){
                System.out.println("Invalid");
                continue;
            }

            if(arr[0] == arr[2]){
                System.out.println("Equilateral");
                continue;
            }

            if(arr[0] == arr[1] || arr[1] == arr[2]){
                System.out.println("Isosceles");
                continue;
            }

            System.out.println("Scalene");

        }
    }
}
