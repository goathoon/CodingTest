package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493 {
    public static void main(String[] args) throws IOException {

        class Tower {
            int h;
            int idx;

            Tower(int h, int idx) {
                this.h = h;
                this.idx = idx;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>();
        int[] answer = new int[N];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[i] > stack.peek().h){
                Tower t = stack.pop();
                answer[t.idx] = i+1;
            }
            stack.add(new Tower(arr[i], i));
        }
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
