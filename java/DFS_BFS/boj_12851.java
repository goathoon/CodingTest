package DFS_BFS;

import java.io.*;
import java.util.*;
public class boj_12851 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parsed = br.readLine().split(" ");
        int N = Integer.parseInt(parsed[0]);
        int K = Integer.parseInt(parsed[1]);
        boolean[] visited = new boolean[100_001];

        Queue<PosAndTime> q = new LinkedList<>();
        q.add(new PosAndTime(N,0));
        visited[N] = true;
        int answer = 0;
        int firstTime = -1;

        while(!q.isEmpty()){
            PosAndTime posAndTime = q.poll();
            int nowPosition = posAndTime.p;
            int nowTime = posAndTime.t;
            visited[nowPosition] = true;

            if (firstTime != -1 && nowTime > firstTime){
                break;
            }

            if (nowPosition == K){
                if (firstTime == -1) {
                    firstTime = nowTime;
                    answer ++;
                    continue;
                }
                else{
                    if (nowTime == firstTime){
                        answer ++;
                        continue;
                    }
                    else{
                        break;
                    }
                }
            }

            if (nowPosition + 1 <= 100000){
                if (!visited[nowPosition + 1])
                    q.add(new PosAndTime(nowPosition + 1, nowTime + 1));
            }

            if (nowPosition - 1 >= 0){
                if (!visited[nowPosition - 1])
                    q.add(new PosAndTime(nowPosition - 1, nowTime + 1));
            }

            if (nowPosition * 2 <= 100000){
                if (!visited[nowPosition * 2])
                    q.add(new PosAndTime(nowPosition * 2, nowTime + 1));
            }
        }
        System.out.println(firstTime);
        System.out.println(answer);
    }
}
class PosAndTime{
    int p;
    int t;
    PosAndTime(int p, int t){
        this.p = p;
        this.t = t;
    }
}
