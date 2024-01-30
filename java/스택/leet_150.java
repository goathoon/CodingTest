package 스택;
import java.util.*;

/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */
public class leet_150 {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for(String s : tokens){
                try{
                    int n = Integer.parseInt(s);
                    stack.add(n);
                }catch(NumberFormatException e){
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    int calNum = cal(n1,n2,s);
                    stack.add(calNum);
                }
            }
            return stack.pop();
        }
        public int cal(int n1, int n2, String op){
            switch(op){
                case "+" : return n2 + n1;
                case "-" : return n2 - n1;
                case "*" : return n2 * n1;
                case "/" : return n2 / n1;
            }
            return 0;
        }
    }
}
