package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_9466 {
    static int[] arr;
    static boolean[] finished;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < TC; tc++){
            answer = 0;
            int len = Integer.parseInt(br.readLine());
            arr = new int[len+1];
            finished = new boolean[len+1];
            visited = new boolean[len+1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int l = 1; l < arr.length; l++){
                arr[l] = Integer.parseInt(st.nextToken());
            }
            dfs(4);
            System.out.println("end");
            for(int i = 1; i < arr.length; i++){
                if(!finished[i]){
                    dfs(i);
                }
            }
            System.out.println(len-answer);
        }
    }
    // 선호하는 팀원을 선택하는 Chain을 깊게 파고들면서, 사이클이 생겼는지 여부를 반환하는 함수.
    // arr[idx] 란 idx번 팀원이 선택한 팀원의 번호
    public static void dfs(int idx){
        System.out.println("idx = " + idx);
        if(finished[idx]) return;
        if(visited[idx]){
            finished[idx] = true;
            answer++;
        }
        visited[idx] = true;
        dfs(arr[idx]);
        finished[idx] = true;
    }
}
