package 백트래킹;
import java.io.*;
import java.util.*;
//public class boj_12865 {
//    static class Thing {
//        int w;
//        int v;
//        Thing(int w, int v){
//            this.w = w;
//            this.v = v;
//        }
//    }
//
//    public static int[][] memo;
//    static Thing[] things;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine(), " ");
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        things = new Thing[N];
//        // 인덱스 N에서 현재 무게가 K인경우 의 최대 가치
//        memo = new int[N][K+1];
//        for(int i = 0; i < memo.length; i++){
//            for(int j = 0; j < memo[0].length; j++){
//                memo[i][j] = -1;
//            }
//        }
//
//        for(int n = 0; n < N; n++){
//            st = new StringTokenizer(br.readLine(), " ");
//            int w = Integer.parseInt(st.nextToken());
//            int v = Integer.parseInt(st.nextToken());
//            things[n] = new Thing(w,v);
//        }
//
//        dfs(0,0,K);
//
//        System.out.println(memo[0][0]);
//    }
//
//    // curIdx 이전까지
//    public static int dfs(int curIdx, int beforeWeight, int maxWeight) {
//        if (beforeWeight > maxWeight) {
//            return 0;
//        }
//        if (curIdx == things.length) {
//            return 0;
//        }
//
//        if (memo[curIdx][beforeWeight] != -1) {
//            return memo[curIdx][beforeWeight];
//        }
//
//        int addValue = things[curIdx].v;
//        int addWeight = things[curIdx].w;
//
//        // 현재 물건을 선택하는 경우
//        int a = 0;
//        if (beforeWeight + addWeight <= maxWeight) {
//            a = addValue + dfs(curIdx + 1, beforeWeight + addWeight, maxWeight);
//        }
//        // 현재 물건을 선택하지 않는 경우
//        int b = dfs(curIdx + 1, beforeWeight, maxWeight);
//
//        return memo[curIdx][beforeWeight] = Math.max(a, b);
//    }
//}

public class boj_12865 {
    static class Thing {
        int w;
        int v;
        Thing(int w, int v){
            this.w = w;
            this.v = v;
        }
    }

    public static int[][] memo;
    static Thing[] things;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        things = new Thing[N];
        // 인덱스 N에서 현재 무게가 K인경우 의 최대 가치
        memo = new int[N][K+1];
        for(int i = 0; i < memo.length; i++){
            for(int j = 0; j < memo[0].length; j++){
                memo[i][j] = -1;
            }
        }

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            things[n] = new Thing(w,v);
        }

        dfs(0,0,0,K);

        System.out.println(memo[0][0]);
        System.out.println(Arrays.deepToString(memo));
    }

    // curIdx 이전까지
    public static int dfs(int curIdx, int value, int beforeWeight, int maxWeight){
        System.out.println("curIdx = " + curIdx + " value = " + value + " beforeWeight = " + beforeWeight + " maxWeight = " + maxWeight);
        if(beforeWeight > maxWeight){
            return 0;
        }
        if(curIdx == things.length){
            return value;
        }

        if(memo[curIdx][beforeWeight] != -1 ){
            return memo[curIdx][beforeWeight];
        }

        int addValue = things[curIdx].v;
        int addWeight = things[curIdx].w;

        // 현재 물건을 선택하는 경우
        int a = dfs(curIdx+1, value + addValue, beforeWeight + addWeight, maxWeight);
        // 현재 물건을 선택하지 않는 경우
        int b = dfs(curIdx+1, value, beforeWeight, maxWeight);

        return memo[curIdx][beforeWeight] = Math.max(a,b);

    }
}


/**
 * 반례
 * 5 7
 * 4 10
 * 1 5
 * 3 20
 * 2 6
 * 5 10
 */