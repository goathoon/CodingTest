package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        int people = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < people+1; i++){
            list.add(new ArrayList<>());
        }

        int[] indegree = new int[people+1];
        Queue<Integer> q = new LinkedList<>();
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int tallP = Integer.parseInt(st.nextToken());
            int smallP = Integer.parseInt(st.nextToken());
            indegree[smallP]++;
            list.get(tallP).add(smallP);
        }
        for(int i = 1; i < people+1; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curP = q.poll();
            sb.append(curP).append(" ");
            for(int next: list.get(curP)){
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
        System.out.println(sb);

    }
}
