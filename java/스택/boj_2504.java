package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class boj_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int mul = 1;
        int result = 0;
        boolean flag = false;
        Loop : for(int i = 0; i < arr.length; i++){
            switch(arr[i]){
                case '(':
                    stack.push('(');
                    mul *= 2;
                    break;

                case '[':
                    stack.push('[');
                    mul *= 3;
                    break;

                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = 0;
                        flag = true;
                        break Loop;
                    }

                    if (arr[i-1] == '(') result += mul;
                    stack.pop();
                    mul /= 2;
                    break;

                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        result = 0;
                        flag = true;
                        break Loop;
                    }

                    if (arr[i-1] == '[') result += mul;
                    stack.pop();
                    mul /= 3;
                    break;

            }
        }
        System.out.println(!stack.isEmpty() || flag ? 0 : result);
    }

}
