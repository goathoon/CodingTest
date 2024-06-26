package 해시;
import java.io.*;
import java.util.*;
public class boj_2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> strings = new ArrayList<>();
        Set<String> ansList = new HashSet<>();
        Map<String, Integer> stringToIndex = new HashMap<>();

        int j = 0;
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            if(stringToIndex.containsKey(s)) continue;
            stringToIndex.put(s,j++);
            strings.add(s);
        }
        Collections.sort(strings);

        int ans = 0;

        for(int i = 0; i < j-1; i++){
            String s1 = strings.get(i);
            String s2 = strings.get(i+1);
            int len = s1.length() < s2.length()? s1.length(): s1.length();
            int cnt = 0;
            for(int l = 0; l < len; l++){
                if(s1.charAt(l) != s2.charAt(l)){
                    break;
                }
                cnt++;
            }
            if(ans < cnt){
                ansList.clear();
                ans = cnt;
                ansList.add(s1);
                ansList.add(s2);
            }
            else if (ans == cnt){
                ansList.add(s1);
                ansList.add(s2);
            }
        }

        List<String> answers = new ArrayList<>(ansList);
        Collections.sort(answers,(s1,s2)->stringToIndex.get(s1)-stringToIndex.get(s2));


        String s1 = answers.get(0);
        for(int i = 1; i < answers.size(); i++){
            String s2 = answers.get(i);
            int len = s1.length() < s2.length()? s1.length(): s2.length();
            int cnt = 0;
            for(int l = 0; l < len; l++){
                if(s1.charAt(l) != s2.charAt(l)){
                    break;
                }
                cnt++;
            }
            if(cnt == ans){
                System.out.println(s1);
                System.out.println(s2);
                return;
            }
        }
    }
}
