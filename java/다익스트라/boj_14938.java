package 다익스트라;

import java.io.*;
import java.util.*;
public class boj_14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int city = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());
        int[] itemOfCity = new int[city+1];
        int INF = Integer.MAX_VALUE;
        int[] distArr = new int[city+1];
        Arrays.fill(distArr,INF);

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i< city+1; i++){
            itemOfCity[i] = Integer.parseInt(st.nextToken());
        }
        List<Pos>[] arr = new ArrayList[city+1];
        for(int i = 1; i < city+1; i ++){
            arr[i] = new ArrayList<Pos>();
        }

        for (int r = 0; r < road; r ++){
            st = new StringTokenizer(br.readLine(), " ");
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            arr[city1].add(new Pos(city2,dist));
            arr[city2].add(new Pos(city1,dist));
        }

        int answer = 0;
        for (int c = 1; c< city+1; c++){
            int curCnt = 0;
            PriorityQueue<Pos> pq = new PriorityQueue<>();
            pq.offer(new Pos(c,0));
            while (!pq.isEmpty()){
                Pos curPos = pq.poll();
                int curCity = curPos.pos;
                int curDist = curPos.dist;
                if (distArr[curCity] != INF){
                    curCnt -= itemOfCity[curCity]; //이미 계산했으므로 빼줌.
                }
                curCnt += itemOfCity[curCity];
                distArr[curCity] = Math.min(distArr[curCity],curDist);
                for(Pos p:arr[curCity]){
                    int nextCity = p.pos;
                    int nextDist = p.dist + curDist;
                    // 이미 최소거리로 갱신이 되어있는 경우 혹은 range 바깥인 경우
                    if (nextDist > range) continue;
                    pq.offer(new Pos(nextCity,nextDist));
                }
            }
            Arrays.fill(distArr,INF);
            answer = Math.max(answer,curCnt);
        }
        System.out.println(answer);
    }
    static class Pos implements Comparable<Pos>{
        int pos;
        int dist;
        Pos (int pos, int dist){
            this.pos = pos;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pos pos){
            return Integer.compare(this.dist, pos.dist);
        }
    }
}
