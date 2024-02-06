package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1201 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Jewel> list = new ArrayList<>();
        int [] bags = new int[K];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            list.add(new Jewel(M, V));
        }
        for(int i = 0; i < K; i++){
            int C = Integer.parseInt(br.readLine());
            bags[i] = C;
        }
        Arrays.sort(bags);
        Collections.sort(list);
        long answer = 0;
        int jewelIdx = 0;
        PriorityQueue<Jewel> pq = new PriorityQueue<>((o1,o2) ->(o2.v - o1.v));

        for(int i = 0; i < K; i++){
            while(jewelIdx < N && list.get(jewelIdx).m <= bags[i]){
                pq.add(list.get(jewelIdx++));
            }
            if(!pq.isEmpty())  {
                Jewel jewel = pq.poll();
                answer += jewel.v;
            }
        }
        System.out.println(answer);
    }
    static class Jewel implements Comparable<Jewel>{
        int m;
        int v;
        public Jewel(int m, int v){
            this.m = m;
            this.v = v;
        }
        public int compareTo(Jewel jewel){
            return this.m - jewel.m;
        }
    }
}
