package 구현;

import java.util.*;

public class leet_1291 {
    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            char[] val = {'1','2','3','4','5','6','7','8','9'};
            List<Integer> list = new ArrayList<>();
            for(int digit = 2; digit <= 9; digit++){
                for(int i = 0; i <= val.length - digit; i++){
                    StringBuilder sb = new StringBuilder();
                    for(int add = 0; add < digit; add++){
                        sb.append(val[i+add]);
                    }
                    int addVal = Integer.parseInt(sb.toString());
                    if(addVal < low || addVal > high) continue;
                    list.add(addVal);
                }
            }
            return list;
        }
    }
}
