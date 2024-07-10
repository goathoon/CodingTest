package MST;
import java.io.*;
import java.util.*;
public class boj_6497_1 {
    static class Road {
        int start;
        int end;
        int cost;
        Road(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    static List<Road> roads = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int house = Integer.parseInt(st.nextToken()), road = Integer.parseInt(st.nextToken());
            if(house == 0 && road == 0) break;

            initParent(house);

            int allRoadCost = 0;
            roads.clear();
            for (int r = 0; r < road; r++) {
                st = new StringTokenizer(br.readLine(), " ");
                int h1 = Integer.parseInt(st.nextToken()), h2 = Integer.parseInt(st.nextToken()), cost = Integer.parseInt(st.nextToken());

                allRoadCost += cost;
                roads.add(new Road(h1, h2, cost));
            }

            Collections.sort(roads, (r1, r2) -> r1.cost - r2.cost);

            int ans = 0;
            for (Road r : roads) {
                int pS = getParent(r.start);
                int pE = getParent(r.end);
                if (pS == pE) continue;
                union(pS, pE);
                ans += r.cost;
            }

            System.out.println(allRoadCost - ans);
        }
    }

    public static void initParent(int cnt){
        parent = new int[cnt];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
    }

    public static void union(int h1, int h2){
        h1 = getParent(h1);
        h2 = getParent(h2);
        if(h1 < h2){
            parent[h2] = h1;
        }
        else{
            parent[h1] = h2;
        }
    }

    public static int getParent(int h){
        if(parent[h] == h) return h;
        return parent[h] = getParent(parent[h]);
    }
}
