import java.io.*;
import java.util.*;
public class boj_2660 {
    static boolean[] visit;
    static class PeopleCost {
         int next;
         int cost;
         PeopleCost(int next, int cost){
             this.next = next;
             this.cost = cost;
         }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int n = 0; n <= N; n++){
            graph.add(new ArrayList<>());
        }

        // 친구 관계도 생성
        while(true){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(n1 == -1) break;

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        Map<Integer, Integer> peopleToScore = new HashMap<>();
        Queue<PeopleCost> q = new LinkedList<>();

        // 각 회원 변호 몇번 관계를 건너가야 하는지 탐색
        for(int i = 1; i <= N; i++){
            visit[i] = true;
            q.add(new PeopleCost(i,0));
            int maxCost = 0;
            while (!q.isEmpty()) {
                PeopleCost curP = q.poll();
                int cur = curP.next;
                int cost = curP.cost;
                maxCost = Math.max(maxCost,cost);
                for(int next : graph.get(cur)){
                    if(visit[next]) continue;
                    visit[next] = true;
                    q.add(new PeopleCost(next, cost+1));
                }
            }
            peopleToScore.put(i, maxCost);
            initVisit();
        }

        int minScore = Integer.MAX_VALUE;

        for(int people : peopleToScore.keySet()){
            if(peopleToScore.get(people) < minScore){
                minScore = peopleToScore.get(people);
            }
        }
        int cnt = 0;
        List<Integer> answer = new ArrayList<>();
        for(int people : peopleToScore.keySet()){
            if(peopleToScore.get(people) == minScore){
                answer.add(people);
                cnt++;
            }
        }
        Collections.sort(answer);
        System.out.println(minScore + " " + cnt);
        for(int p : answer){
            System.out.printf("%d ", p);
        }
    }

    public static void initVisit(){
        for(int i = 0; i < visit.length; i++){
            visit[i] = false;
        }
    }
}
