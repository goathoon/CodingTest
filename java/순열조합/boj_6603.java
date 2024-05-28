package 순열조합;
import java.io.*;
import java.util.*;
public class boj_6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            dfs(0, 0,new boolean[N], arr);
            System.out.println();
        }

    }
    public static void dfs(int curIdx, int curDepth, boolean[] visited, int[] arr){
        if(curDepth == 6){
            for(int i = 0; i < visited.length; i++){
                if(visited[i]){
                    System.out.printf("%d ", arr[i]);
                }
            }
            System.out.printf("\n");
            return;
        }
        if(curIdx == arr.length) return;

        for(int i = curIdx; i < arr.length; i++){
            visited[i] = true;
            // 여기서 curIdx+1로 하면 큰일난다!!
            dfs(i+1, curDepth + 1, visited, arr);
            visited[i] = false;
        }
    }
}
