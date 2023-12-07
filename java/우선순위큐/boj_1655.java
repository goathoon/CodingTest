package 우선순위큐;
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj_1655 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < cnt+1; i++){
            int val = Integer.parseInt(br.readLine());
            if (maxPQ.size() == minPQ.size()){
                maxPQ.offer(val);
                if (! minPQ.isEmpty() && minPQ.peek()  < maxPQ.peek()){
                    maxPQ.offer(minPQ.poll());
                    minPQ.offer(maxPQ.poll());
                }
            }
            else {
                minPQ.offer(val);
                if( minPQ.peek() < maxPQ.peek()){
                    minPQ.offer(maxPQ.poll());
                    maxPQ.offer(minPQ.poll());
                }
            }
            sb.append(maxPQ.peek() +"\n");
        }
        System.out.println(sb);
    }
}