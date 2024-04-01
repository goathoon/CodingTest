package 그리디;

import java.io.*;
import java.util.*;

public class boj_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        Deque<Character> dq = new LinkedList<>();
        int pop = K;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            while(!dq.isEmpty() && dq.peekLast() < c && pop >= 1){
                dq.removeLast();
                pop -= 1;
            }
            dq.addLast(c);
        }
        StringBuilder sb = new StringBuilder();
        if(pop > 0){
            for(int i = 0; i < N-K; i++){
                sb.append(dq.removeFirst());
            }
        }
        else{
            while(!dq.isEmpty()){
                sb.append(dq.removeFirst());
            }
        }
        System.out.println(sb.toString());
    }
}
