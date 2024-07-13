package 그리디;
import java.io.*;
import java.util.*;
public class boj_1339 {
    static class CharToNum {
        char c;
        int n;
        CharToNum(char c, int n){
            this.c = c;
            this.n = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Character,Integer> map = initCharMap();

        String[] strings = new String[N];
        for(int n = 0; n < N; n++){
            String s = br.readLine();
            strings[n] = s;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                int newPos = s.length() - i - 1;
                map.put(c, map.get(c) + (int) Math.pow(10,newPos));
            }
        }

        List<CharToNum> list = new ArrayList<>();
        for(Character c : map.keySet()){
            if(map.get(c) != 0){
                list.add(new CharToNum(c,map.get(c)));
            }
        }

        Collections.sort(list, (c1,c2) -> c2.n - c1.n);

        Map<Character, Integer> mappingNum = new HashMap<>();
        int max = 9;
        for(CharToNum ctn : list){
            char cur = ctn.c;
            mappingNum.put(cur, max--);
        }

        int ans = 0;

        for(String s : strings){
            ans += mapToInt(s,mappingNum);
        }
        System.out.println(ans);
    }

    public static Map<Character,Integer> initCharMap(){
        Map<Character, Integer> map = new HashMap<>();
        for(char c = 'A'; c <= 'Z'; c++){
            map.put(c, 0);
        }
        return map;
    }

    public static int mapToInt(String s, Map<Character, Integer> mapper){
        int val = 0;
        for(int i = 0; i < s.length(); i++){
            int pos = s.length() -1 -i;
            val += Math.pow(10,pos) * mapper.get(s.charAt(i));
        }
        return val;
    }

}
