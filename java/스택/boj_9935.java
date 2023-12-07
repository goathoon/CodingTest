package 스택;
import java.io.*;
import java.util.*;
public class boj_9935 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] sArr = s.toCharArray();
        String bomb = br.readLine();
        char[] answer = new char[bomb.length()];
        Stack<Character> stack = new Stack<>();
        Loop:
        for (int i = 0; i < sArr.length; i ++){
            stack.push(sArr[i]);
            if (stack.size() >= bomb.length()){
                int idx = bomb.length() - 1;
                while(idx >=0){
                    answer[idx] = stack.pop();
                    if (answer[idx] != bomb.charAt(idx)){
                       while (idx <= bomb.length() -1 ){
                           stack.push(answer[idx++]);
                       }
                       continue Loop;
                    }
                    idx --;
                }
            }
        }
        if(stack.empty()){
            System.out.println("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int idx = 0; idx < stack.size(); idx ++){
            sb.append(stack.get(idx));
        }

        System.out.println(sb);
    }
}
