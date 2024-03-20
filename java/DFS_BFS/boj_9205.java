package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class boj_9205 {
    public static void main(String[] args) throws IOException {
        class Groc{
            int x;
            int y;
            Groc(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < TC; tc++){
            int cnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            List<Groc> list = new ArrayList<>();
            Queue<Groc> q = new LinkedList<>();
            boolean[] visited = new boolean[cnt];
            q.add(new Groc(startX,startY));
            for(int c = 0; c < cnt; c++){
                st = new StringTokenizer(br.readLine(), " ");
                int midX = Integer.parseInt(st.nextToken());
                int midY = Integer.parseInt(st.nextToken());
                list.add(new Groc(midX, midY));
            }
            st = new StringTokenizer(br.readLine(), " ");
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            boolean isEnd = false;
            while(!q.isEmpty()){
                Groc cur = q.poll();
                int curX = cur.x;
                int curY = cur.y;
                if(Math.abs(curX-endX) + Math.abs(curY - endY) <= 1000){
                    isEnd= true;
                    break;
                }
                for(int i = 0; i < list.size(); i++){
                    if(visited[i]) continue;
                    Groc g = list.get(i);
                    if (Math.abs(g.x - curX) + Math.abs(g.y-curY) <= 1000){
                        visited[i] = true;
                        q.add(g);
                    }
                }
            }
            if(isEnd) System.out.println("happy");
            else System.out.println("sad");
        }

    }
}
