package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] height = new int[W];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < W; i ++){
            height[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int h = 0; h < H; h++){
            for(int w = 0; w < W; w++){
                if(height[w] >= h+1){
                    if(stack.isEmpty()){
                        stack.push(w);
                    }
                    else{
                        int l = stack.pop();
                        int r = w;
                        stack.push(r);
                        answer += r-l-1;
                    }
                }
            }
            stack.clear();
        }
        System.out.println(answer);
    }
}
