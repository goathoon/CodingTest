package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17298 {
    public static void main(String[] args) throws IOException {
        class NumberAndIndex{
            int num;
            int idx;
            NumberAndIndex(int num, int idx){
                this.num = num;
                this.idx = idx;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<NumberAndIndex> stack = new Stack<>();
        int[] answer = new int[N];
        for(int i = 0; i < N; i ++){
            answer[i] = -1;
        }

        for(int i = 0; i < N; i++){
            int curNum = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek().num < curNum){
                NumberAndIndex ele = stack.pop();
                answer[ele.idx] = curNum;
            }
            stack.add(new NumberAndIndex(curNum,i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);

    }
}
