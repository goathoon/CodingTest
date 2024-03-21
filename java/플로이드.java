import java.io.*;
import java.util.*;
public class 플로이드 {
    class Main{
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            boolean[][] graph = new boolean[N+1][N+1];
            for(int c = 0; c < cnt; c++){
                st = new StringTokenizer(br.readLine(), " ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                graph[n1][n2] = true;
            }
            for(int k = 1; k <= N; k++){
                for(int i = 1; i <= N; i++){
                    for(int j = 1; j <= N; j++){
                        if(graph[i][k] && graph[k][j]){
                            graph[i][j] = true;
                        }
                    }
                }
            }
            int ans = 0;
            Loop : for(int i = 1; i <= N; i++){
                for(int start = 1; start <= N; start++){
                    if(start == i) continue;
                    if(!graph[start][i] && !graph[i][start]) continue Loop;
                }
                ans++;
            }
            System.out.println(ans);
        }
    }
}
