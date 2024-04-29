package 스택;

import java.io.*;
import java.util.*;

public class boj_1863 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(stack.isEmpty() || stack.peek() < h){
                if(h==0) continue;
                stack.push(h);
            }
            else if(stack.peek() > h){
                while(!stack.isEmpty() && stack.peek() > h){
                    stack.pop();
                    answer++;
                }
                if(stack.isEmpty() || stack.peek() < h){
                    if(h==0) continue;
                    stack.push(h);
                }
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
            answer++;
        }
        System.out.println(answer);
    }
}
