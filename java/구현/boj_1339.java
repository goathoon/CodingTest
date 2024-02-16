package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> mapToInt = new HashMap<>();
        Map<Character, Integer> mapToBig = new HashMap<>();
        class KeyComparator implements Comparator{
            public int compare(Object o1, Object o2) {
                return mapToBig.get(o2) -  mapToBig.get(o1);
            }
        }
        int n = Integer.parseInt(br.readLine());
        List<String> strings = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            strings.add(s);
            for(int idx = 0; idx < s.length(); idx++){
                char curC = s.charAt(idx);
                if(mapToBig.containsKey(curC)){
                    int prev = mapToBig.get(curC);
                    mapToBig.put(s.charAt(idx), prev + (int)Math.pow(10, s.length()-idx));
                }
                else{
                    mapToBig.put(s.charAt(idx),(int)Math.pow(10, s.length()-idx));
                }
            }
        }
        List<Character> list = new ArrayList<>(mapToBig.keySet());
        Collections.sort(list,new KeyComparator());
        int now = 9;
        for(char c : list){
            mapToInt.put(c,now--);
        }
        int ans = 0;
        for(String s : strings){
            for(int i = 0; i < s.length(); i ++){
                ans += (int)Math.pow(10,(s.length() - i)-1) * mapToInt.get(s.charAt(i));
            }
        }
        System.out.println(ans);
    }
}
