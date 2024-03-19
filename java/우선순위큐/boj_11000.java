package 우선순위큐;
import java.util.*;
import java.io.*;
public class boj_11000 {

        public static void main(String[] args) throws IOException {
            class Class{
                int start;
                int end;
                Class(int start, int end){
                    this.start = start;
                    this.end = end;
                }
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            Class[] classes = new Class[N];
            PriorityQueue<Class> pq = new PriorityQueue<>((c1,c2)->c1.end-c2.end);
            StringTokenizer st;
            for(int i = 0 ; i < N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                classes[i] = new Class(start,end);
            }
            Arrays.sort(classes,(c1,c2)->c1.start-c2.start);
            pq.add(classes[0]);
            int answer = 1;
            for(int i = 1; i < N; i++){
                Class curClass = pq.peek();
                if(curClass.end <= classes[i].start){
                    pq.poll();
                }
                else{
                    answer++;
                }
                pq.add(classes[i]);
            }
            System.out.println(answer);
        }
}
