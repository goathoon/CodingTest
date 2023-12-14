package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int customer = Integer.parseInt(st.nextToken());
        int chicken = Integer.parseInt(st.nextToken());

        int[][] satisfy = new int[customer][chicken];
        List<int[]> chickenChoices = new ArrayList<>();
        boolean[] visited = new boolean[chicken];
        for(int i = 0 ; i < customer; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < chicken ; c++){
                satisfy[i][c] = Integer.parseInt(st.nextToken());
            }
        }
        getChicken(chickenChoices,visited,0,0,3);

        int answer = 0;
        for(int[] c: chickenChoices){
            int candAnswer = 0;
            for( int i = 0 ; i < customer; i ++){
                candAnswer += getMaxSat(satisfy[i],c);
            }
            answer = Math.max(candAnswer,answer);
        }
        System.out.println(answer);
    }
    public static void getChicken(List<int[]> chickChoice, boolean[] visited, int curIdx, int depth, int targetCnt){
        if(depth == targetCnt){
            int[] choice = new int[3];
            int cur = 0;
            for(int i = 0; i < visited.length; i++){
                if(visited[i]){
                    choice[cur++] = i;
                }
            }
            chickChoice.add(choice);
            return;
        }
        for(int i = curIdx; i < visited.length; i ++){
            visited[i] = true;
            getChicken(chickChoice, visited,i+1,depth+1,targetCnt);
            visited[i] = false;
        }
    }
    public static int getMaxSat(int[] personSat, int[] chicken){
        int f = chicken[0];
        int s = chicken[1];
        int t = chicken[2];
        return Math.max(Math.max(personSat[f],personSat[s]),personSat[t]);
    }
}
