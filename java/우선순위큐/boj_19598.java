package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] meet = new int[N][2];
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meet[n] = new int[]{s,e};
        }
        Arrays.sort(meet,(m1,m2)->m1[0]-m2[0]);
        PriorityQueue<Integer> finish = new PriorityQueue<>((i1,i2)->i1-i2);
        int ans = 1;
        for(int m = 0; m < meet.length; m++){
            int curS = meet[m][0];
            int curE = meet[m][1];
            if(finish.isEmpty()){
                finish.offer(curE);
            }
            else{
                //먼저 시작된 회의가 뒤이어 시작할 회의보다 먼저 끝나는 경우
                while(!finish.isEmpty() && finish.peek() <= curS){
                    finish.poll();
                }
                finish.offer(curE);
                // 마련된 회의실 보다 현재 진행중인 회의가 많으면 회의실 하나 추가
                if(ans < finish.size()) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
