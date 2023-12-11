import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        long[] height = new long[cnt];
        for(int i = 0; i < cnt; i++){
            height[i] = Long.parseLong(br.readLine());
        }
        long answer = 0;

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i< cnt; i++){
            while(!s.isEmpty()){
                if(height[s.peek()] >= height[i]){
                    long h = height[s.pop()];
                    long width = s.isEmpty() ? i : i - s.peek() - 1;
                    answer = Math.max(answer, h * width);
                }
                else{
                    break;
                }
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            int idx = s.pop();
            long h = height[idx];
            // 왜 width가 이렇게 되는지 생각
            long width = s.isEmpty() ? cnt : cnt -1 - s.peek();
            answer = Math.max(answer, h * width);
        }
        System.out.println(answer);
    }
}
