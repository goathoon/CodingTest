package 구현;
import java.util.*;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 */
public class leet_6 {

    class Solution {
        public String convert(String s, int numRows) {
            StringBuilder sb = new StringBuilder();

            if(numRows == 1){
                return s;
            }

            List[] list = new ArrayList[numRows];
            for(int i = 0; i <numRows; i++){
                list[i] = new ArrayList();
            }
            char[] chars = s.toCharArray();
            int curIdx = 0;
            boolean isDown = true;
            for(char c : chars){
                if(isDown){
                    list[curIdx++].add(c);
                    if(curIdx == numRows){
                        isDown = false;
                        curIdx --;
                    }
                }
                else{
                    list[--curIdx].add(c);
                    if(curIdx == 0) {
                        isDown = true;
                        curIdx++;
                    }
                }
            }
            for(int i = 0; i < numRows; i++){
                for(Object c : list[i]){
                    sb.append((char)c);
                }
            }
            return sb.toString();
        }
    }
}
