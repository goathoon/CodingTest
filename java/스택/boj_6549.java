package 스택;
import java.io.*;
import java.util.*;
public class boj_6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            if (cnt == 0) return;

            int[] height = new int[cnt];
            for (int i = 0; i < cnt; i++) height[i] = Integer.parseInt(st.nextToken());
            long answer = 0L;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < cnt; i++) {

                while ((!stack.isEmpty()) && height[stack.peek()] >= height[i]) {
                    long h = height[stack.pop()];
                    long weight = (stack.isEmpty()) ? i : (i - stack.peek() - 1);
                    answer = Math.max(answer, h * weight);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                long h = height[stack.pop()];
                long weight = (stack.isEmpty()) ? cnt : (cnt - stack.peek() - 1);
                answer = Math.max(answer, h * weight);
            }
            System.out.println(answer);

        }
    }
}
