package 그리디;

import java.io.*;
import java.util.*;

class boj_16496 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        Collections.sort(list,new Comparator<>(){
            public int compare(String s1, String s2){
                return (s1+s2).compareTo(s2+s1) * -1;
            }
        });

        if(list.get(0).charAt(0) == '0'){
            System.out.println(0);
        }
        else{
            String s = "";
            for(int i = 0; i < list.size(); i++){
                s = s + list.get(i);
            }
            System.out.println(s);
        }

    }
}