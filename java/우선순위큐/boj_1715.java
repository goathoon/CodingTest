package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        long answer = 0;
        while(true){
            if(pq.size() >= 2){
                int n1 = pq.poll();
                int n2 = pq.poll();
                pq.add(n1+n2);
                answer += n1 + n2;
            }
            else{
                break;
            }
        }
        System.out.println(answer);
    }
}
