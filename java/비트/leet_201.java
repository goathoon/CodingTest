package 비트;

public class leet_201 {
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            int shift = 0;
            while(left < right){
                left >>= 1;
                right >>= 1;
                ++shift;
            }
            return left << shift;
        }
    }
}
