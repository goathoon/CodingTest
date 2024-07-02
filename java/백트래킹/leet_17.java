package 백트래킹;
import java.util.*;
public class leet_17 {
    static List<String> answer = new ArrayList<>();
    static Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        // leet에서 이거 안해주면 이전 테스트케이스에 static변수에 값이 유지 되어있어서 문제가 생김
        answer.clear();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        char [] curString = new char[digits.length()];
        dfs(0, digits.length(), digits, curString);

        return answer;
    }

    public void dfs(int curIdx, int maxIdx, String digits, char[] curString){

        if(curIdx == maxIdx){
            // char 배열 어떻게 String으로 변환하냐
            if(maxIdx == 0) return;
            answer.add(new String(curString));
            return;
        }

        char c = digits.charAt(curIdx);
        String s = map.get(c);
        for(int i = 0; i < s.length(); i++){
            curString[curIdx] = s.charAt(i);
            dfs(curIdx+1,maxIdx, digits, curString);
        }

    }
}
