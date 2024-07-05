package 우선순위큐;
import java.io.*;
import java.util.*;
public class boj_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()),  P = Integer.parseInt(st.nextToken());
        List<PriorityQueue<Integer>> lines = new ArrayList<>();
        for(int n = 0; n <= N; n++){
            lines.add(new PriorityQueue<>(Comparator.reverseOrder()));
        }

        int ans = 0;
        PriorityQueue<Integer> curLine;

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            int line = Integer.parseInt(st.nextToken()), plat = Integer.parseInt(st.nextToken());
            curLine = lines.get(line);
            while(curLine.size() > 0 && curLine.peek() > plat){
                curLine.poll();
                ans++;
            }
            if(curLine.size() > 0 && curLine.peek() == plat){
                continue;
            }
            curLine.add(plat);
            ans++;
        }

        System.out.println(ans);
    }
}
