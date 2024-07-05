package 스택;

import java.io.*;
import java.util.*;

public class boj_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()),  P = Integer.parseInt(st.nextToken());
        List<Stack<Integer>> lines = new Stack<>();
        for(int n = 0; n <= N; n++){
            lines.add(new Stack<>());
        }

        Stack<Integer> curLine;
        int ans = 0;
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            int line = Integer.parseInt(st.nextToken()), plat = Integer.parseInt(st.nextToken());
            curLine = lines.get(line);
            while(!curLine.isEmpty() && curLine.peek() > plat){
                curLine.pop();
                ans++;
            }
            if(curLine.size() != 0 && curLine.peek() == plat){
                continue;
            }
            curLine.push(plat);
            ans++;
        }
        System.out.println(ans);
    }
}
