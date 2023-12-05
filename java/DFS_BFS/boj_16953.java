package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16953 {
    static class IntegerAndDepth{
        int num;
        int depth;
        IntegerAndDepth(int num, int depth){
            this.num = num;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        long INF = Long.MAX_VALUE;
        Queue<IntegerAndDepth> q = new LinkedList<>();
        q.add(new IntegerAndDepth(start,0));
        while (!q.isEmpty()){
            IntegerAndDepth now = q.poll();
            if (now.num > end){
                continue;
            }
            if (now.num == end){
                System.out.println(now.depth + 1);
                return;
            }
            if ((long)now.num * 2 <= (long)end){
                q.add(new IntegerAndDepth(now.num * 2,now.depth + 1));
            }
            if ((long)now.num * 10 + 1 <= (long)end){
                q.add(new IntegerAndDepth(now.num * 10 + 1,now.depth + 1));
            }
        }
        System.out.println(-1);
    }
}
