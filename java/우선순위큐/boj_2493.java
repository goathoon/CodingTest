package 우선순위큐;
import java.util.*;
import java.io.*;
public class boj_2493 {
    public static void main(String[] args) throws IOException {

        class Tower {
            int h;
            int idx;

            Tower(int h, int idx) {
                this.h = h;
                this.idx = idx;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Tower> pq = new PriorityQueue<>((t1, t2) -> t1.h - t2.h);
        int[] answer = new int[N];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N - 1; i >= 0; i--) {
            while (!pq.isEmpty()) {
                if (arr[i] > pq.peek().h) {
                    Tower t = pq.poll();
                    answer[t.idx] = i+1;
                } else break;
            }
            pq.add(new Tower(arr[i], i));
        }
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
