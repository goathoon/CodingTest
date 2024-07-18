package 브루트포스;
import java.io.*;
import java.util.*;
public class boj_15661 {
    static boolean[] visit;
    static List<boolean[]> comb = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] grid = new int[N+1][N+1];
        visit = new boolean[N+1];

        for(int n = 1; n <= N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 1; c <= N; c++){
                grid[n][c] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int chose = 1; chose < N; chose++){
            comb.clear();
            dfs(0,chose,1);
            for(boolean[] visit : comb){
                int p1 = 0;
                int p2 = 0;
                for(int i = 1; i < visit.length; i++){
                    for(int j = 1; j < visit.length; j++){
                        if(visit[i]){
                            if(visit[j]){
                                p1 += grid[i][j];
                            }
                        }
                        else{
                            if(!visit[j]){
                                p2 += grid[i][j];
                            }
                        }
                    }
                }
                ans = Math.min(ans, Math.abs(p1-p2));
            }
        }
        System.out.println(ans);
    }

    public static void dfs(int cur, int depth, int curPerson){
        if(cur == depth){
            boolean[] addVisit = new boolean[visit.length];
            for(int i = 1; i < visit.length; i++){
                if(visit[i]) {
                    addVisit[i] = true;
                }
            }
            comb.add(addVisit);
            return;
        }

        if(curPerson == visit.length) {
            return;
        }

        for(int startPerson = curPerson; startPerson < visit.length; startPerson++){
            if(!visit[startPerson]){
                visit[startPerson] = true;
                dfs(cur+1, depth, startPerson+1);
                visit[startPerson] = false;
            }
        }
    }
}
