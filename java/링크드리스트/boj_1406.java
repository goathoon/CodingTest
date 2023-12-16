package 링크드리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s = br.readLine();
        LinkedList<Character> ll = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            ll.add(s.charAt(i));
        }
        //맨 마지막 원소의 오른쪽(마지막커서)를 가리키게 함.
        ListIterator it =ll.listIterator(s.length());
        int cmd = Integer.parseInt(br.readLine());
        for(int i = 0; i < cmd; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String c = st.nextToken();

            if(c.equals("P")){
                it.add(st.nextToken().charAt(0));
            }
            else if (c.equals("L")){
                if(it.hasPrevious()){
                    it.previous();
                }
            }
            else if (c.equals("D")){
                if(it.hasNext()){
                    it.next();
                }
            }
            else if (c.equals("B")){
                if(it.hasPrevious()){
                    it.previous();
                    it.remove();
                }
            }
        }
        it = ll.listIterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            sb.append(it.next());
        }
        System.out.println(sb);
    }
}
