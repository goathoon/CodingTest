package 순열조합;
import java.io.*;
import java.util.*;
public class boj_1941 {
    static class Pos{
        int row;
        int col;
        Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static char[][] grid;
    static Pos[] pos = new Pos[25];
    static int ans= 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        grid = new char[5][5];
        for(int r = 0; r < 5; r++){
            grid[r] = br.readLine().toCharArray();
        }
        int idx = 0;
        for(int r = 0; r < 5; r++){
            for(int c = 0; c < 5; c++){
                pos[idx++] = new Pos(r,c);
            }
        }
        dfs(0,0,new Pos[7]);
        System.out.println(ans);
    }

    public static void dfs(int cnt, int idx, Pos[] chose){
        if(cnt == 7){
            if(checkS(chose) && checkConnect(chose)){
                ans++;
            }
            return;
        }

        if(idx >= 25) return;
        for(int i = idx; i < pos.length; i++){
            chose[cnt] = pos[i];
            dfs(cnt+1,i+1,chose);
        }
    }

    public static boolean checkS(Pos[] chose){
        int cnt = 0;
        for(Pos p : chose){
            if(grid[p.row][p.col] == 'S'){
                cnt++;
                if(cnt >= 4){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkConnect(Pos[] chose){
        boolean[] isVisit = new boolean[7];
        Queue<Pos> q = new LinkedList<>();
        q.add(chose[0]);
        isVisit[0] = true;
        while(!q.isEmpty()){
            Pos cur = q.poll();
            for(int i = 0; i < chose.length; i++){
                if(!isVisit[i] && isConnect(cur,chose[i])){
                    q.add(chose[i]);
                    isVisit[i] = true;
                }
            }
        }
        for(int i = 0; i < isVisit.length; i++){
            if(!isVisit[i]) return false;
        }
        return true;
    }
    public static boolean isConnect(Pos p1, Pos p2){
        if(Math.abs(p1.col - p2.col) + Math.abs(p1.row - p2.row) == 1) return true;
        return false;
    }
}
