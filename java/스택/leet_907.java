package 스택;
import java.util.*;
public class leet_907 {

    class Solution {
        public int sumSubarrayMins(int[] arr) {
            Stack<Ele> stack = new Stack<>();
            long result = 0l;
            int mod = 1000000007;

            for(int i = 0; i < arr.length; i++){
                // 현재 monotonic stack이 갱신되어야 하는 경우 (stack이 오름차순에서 꺠지는 경우)
                while(!stack.isEmpty() && stack.peek().num >= arr[i]){
                    Ele beforeEle = stack.pop();
                    // 작은 원소의 삽입 index "i" 에서 pop되어야 하는 원소의 index "beforeEle.idx" 를 빼서 오른쪽 subarray의 원소의 개수를 구함

                    // 왼쪽 subarray의 개수를 구하기 위함 -> pop하고 stack이 비었다는 것은 pop 한 수가 새 원소를 추가하기 이전까지 최소값이었다는 것임
                    long left = stack.isEmpty()? beforeEle.idx + 1 : beforeEle.idx - stack.peek().idx;
                    long right = i - beforeEle.idx;
                    long count = (left * right) % mod;
                    result += count * beforeEle.num;
                    result %= mod;
                }
                stack.add(new Ele(i, arr[i]));
            }
            Ele lastEle = stack.peek();
            while(!stack.isEmpty()){
                Ele beforeEle = stack.pop();

                long left = stack.isEmpty()? beforeEle.idx + 1 : beforeEle.idx - stack.peek().idx;
                // 아래의 경우 놓치는 케이스가 발생. 2 3 4 5 3 일 경우
                // int right = lastEle.idx - beforeEle.idx + 1;
                long right = arr.length - beforeEle.idx ;
                long count = (left * right) % mod;
                result += count * beforeEle.num;
                result %= mod;
            }
            return (int)result;
        }

    }

    class Ele {
        int idx;
        int num;
        Ele(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }
}
