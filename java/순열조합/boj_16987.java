package 순열조합;
import java.io.*;
import java.util.*;
public class boj_16987 {
    static class Egg{
        int d;
        int w;

        Egg(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }
    static Egg[] eggs;
    static boolean[] visit;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        eggs = new Egg[N];
        visit = new boolean[N];
        for(int n = 0; n < N; n++){
            int d = sc.nextInt();
            int w = sc.nextInt();
            eggs[n] = new Egg(d,w);
        }
        // 가장 왼쪽의 계란을 든다
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int curIdx){
        // 종료 조건 (지금 든 계란이 out of index)
        if(curIdx == eggs.length){
            int cnt = 0;
            for(int i = 0; i < eggs.length; i++){
                if(eggs[i].d <= 0){
                    cnt++;
                }
            }
            answer = Math.max(answer,cnt);
            return;
        }
        // 들고 있는 계란이 깨진 상태
        if(eggs[curIdx].d <= 0){
            dfs(curIdx+1);
            return;
        }
        // 꺨 계란 탐색
        boolean none = true;
        for(int i = 0; i < eggs.length; i++){
            if(i == curIdx) continue;
            if(eggs[i].d > 0){
                none = false;
                eggs[curIdx].d -= eggs[i].w;
                eggs[i].d -= eggs[curIdx].w;
                dfs(curIdx+1);
                eggs[curIdx].d += eggs[i].w;
                eggs[i].d += eggs[curIdx].w;
            }
        }
        if(none){
            dfs(curIdx+1);
        }
    }

}
