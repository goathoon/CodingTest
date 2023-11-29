package 수학;

import java.io.*;
import java.util.StringTokenizer;
public class boj_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i<tc; i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = e - s;
            int n = 1;
            
            while(true){
                long x = n*n + n;
                long priorX = (n-1)*(n-1) + n-1;
                if (dist == x) {
                    System.out.println(2*n);
                    break;
                }
                else if ((dist / x) < 1){
                    if ((dist - (int)priorX) / (n+1) == 0){
                        System.out.println(2*(n-1) + 1);
                        break;
                    }
                    else if ((dist - (int)priorX) / (n+1) == 1) {
                        System.out.println(2*(n-1)+2);
                        break;
                    }
                }
                n += 1;

            }
        }
    }
}
