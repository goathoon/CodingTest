package 우선순위큐;
import java.io.*;
import java.util.*;
public class boj_1417 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Integer i1, Integer i2){
                return i2.compareTo(i1);
            }
        });
        for(int i = 1; i < N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        while(pq.size() != 0 && target <= pq.peek()){
            int top = pq.poll();
            pq.offer(top-1);
            target++;
            ans++;
        }
        System.out.println(ans);

    }
}
