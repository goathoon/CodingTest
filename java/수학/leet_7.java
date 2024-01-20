package 수학;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 */
public class leet_7 {

    class Solution {
        public int reverse(int x) {
            String s = Integer.toString(x);
            char[] arr = s.toCharArray();
            int len = arr.length;
            char[] ans = new char[len];

            char[] maxArr = Integer.toString(Integer.MAX_VALUE).toCharArray();
            char[] minArr = Integer.toString(Integer.MIN_VALUE).toCharArray();

            boolean isOut = false;

            if(x<0){
                ans[0] = '-';
                for(int i = 1, j = len - 1; i < len; i ++, j --){
                    ans[i] = arr[j];
                }
                if(ans.length == minArr.length && ans[1] > '0'){
                    for(int i = 1; i < len; i++){
                        if(ans[i] < minArr[i]){
                            break;
                        }
                        else if (ans[i] == minArr[i]){
                            continue;
                        }
                        else{
                            isOut = true;
                            break;
                        }
                    }
                }
            }
            else{
                for(int i = 0, j = len-1; i < len; i++, j--){
                    ans[i] = arr[j];
                }
                if(ans.length == maxArr.length && ans[0] > '0'){
                    for(int i = 0; i < len; i++){
                        if(ans[i] < maxArr[i]){
                            break;
                        }
                        else if (ans[i] == maxArr[i]){
                            continue;
                        }
                        else{
                            isOut = true;
                            break;
                        }
                    }
                }
            }
            if(isOut) return 0;
            return Integer.parseInt(new String(ans));
        }
    }
}
