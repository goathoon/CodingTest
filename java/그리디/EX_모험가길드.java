package 그리디;

import java.io.*;
import java.util.*;

public class EX_모험가길드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> people = new ArrayList<>();
        while(st.hasMoreTokens()){
            people.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(people);

        int cur = 0;
        int ans = 0;
        for(int i = 0; i < people.size(); i++){
            cur++;
            if(people.get(i) <= cur){
                cur = 0;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
