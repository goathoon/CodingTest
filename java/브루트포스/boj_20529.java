package 브루트포스;

import java.io.*;
import java.util.*;
public class boj_20529 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i ++){
            int people = Integer.parseInt(br.readLine());
            //비둘기집 원리 BruteForce 이지만, 한정된 케이스(엠비티아이 유형의 개수)에서 사람이 아무리 많아봤자 항상 답은 같다.
            if (people >= 33) {
                System.out.println(0);
                // readLine한번 더 해줘야함
                br.readLine();
                continue;
            }
            st = new StringTokenizer(br.readLine(), " ");
            String[] mbtiArr = new String[people];
            for (int p = 0; p < people; p ++){
                String key = st.nextToken();
                mbtiArr[p] = key;
            }
            System.out.println(getMinOfDist(mbtiArr));
        }
    }
    static int getMinOfDist(String[] arr){
        boolean[] visited = new boolean[arr.length];
        String[] caseArr = new String[3];
        List<String> casesOfArr = new LinkedList<>();
        combinations(arr,visited, caseArr, casesOfArr,0,0);
        // 여기 잘 봐야함 toArray 문법
        String[] cases = casesOfArr.toArray(new String[casesOfArr.size()]);
        return calMinDist(cases);
    }
    static int calMinDist(String[] cases){
        StringTokenizer st;
        int min =999999999;
        for(String c: cases){
            st = new StringTokenizer(c," ");
            int caseDist = 0;
            String c1 = st.nextToken();
            String c2 = st.nextToken();
            String c3 = st.nextToken();
            caseDist += getDist(c1,c2);
            caseDist += getDist(c1,c3);
            caseDist += getDist(c2,c3);
            min = Math.min(min,caseDist);
        }
        return min;
    }
    static int getDist(String s1, String s2){
        int dist = 0;
        for(int i = 0; i<4; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                dist += 1;
            }
        }
        return dist;
    }
    static void combinations(String[] arr, boolean[] visited, String[] caseArr, List<String> result, int startIdx, int depth){
        StringBuilder sb = new StringBuilder();
        if (depth == 3){
            for (String s: caseArr){
                sb.append(s + " ");
            }
            result.add(sb.toString());
            return;
        }

        for(int idx = startIdx; idx < arr.length; idx ++){
            visited[idx] = true;
            caseArr[depth] = arr[idx];
            combinations(arr,visited,caseArr,result,idx+1,depth+1);
            visited[idx] = false;
        }
    };
}
