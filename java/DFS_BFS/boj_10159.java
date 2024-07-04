package DFS_BFS;
import java.io.*;
import java.util.*;
public class boj_10159 {
    static List<List<Integer>> biggerGraph = new ArrayList<>();
    static List<List<Integer>> smallerGraph = new ArrayList<>();
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int n = 0; n <= N; n++){
            biggerGraph.add(new ArrayList<>());
            smallerGraph.add(new ArrayList<>());
        }

        visit = new boolean[N+1];

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            biggerGraph.get(s).add(e);
            smallerGraph.get(e).add(s);
        }

        for(int s = 1; s <= N; s++){
            System.out.println(N - biggerDfs(s) - smallerDfs(s) + 1);
            initVisit();
        }
    }

    public static void initVisit(){
        Arrays.fill(visit,false);
    }

    public static int biggerDfs(int s){
        visit[s] = true;

        int val = 1;
        for(int next : biggerGraph.get(s)){
            if(!visit[next]) {
                val += biggerDfs(next);
            }
        }
        return val;
    }

    public static int smallerDfs(int e){
        visit[e] = true;

        int val = 1;
        for(int next : smallerGraph.get(e)){
            if(!visit[next]) {
                val += smallerDfs(next);
            }
        }
        return val;
    }
}
