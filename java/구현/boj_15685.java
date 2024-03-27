package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_15685 {
    public static void main(String[] args) throws IOException {
        //커브의 방향 순서대로, 역방향으로 하면 됨.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[101][101];
        List<Pos> list;
        for(int n = 0; n < N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            list = setCurve(x,y,g,d);
            setGrid(grid,list);
            list.clear();
        }
        int ans = 0;
        for(int y = 0; y <= 99; y++){
            for(int x = 0; x <= 99; x++){
                if(grid[y][x] != 0 && grid[y+1][x] != 0 && grid[y][x+1] != 0 && grid[y+1][x+1] != 0){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
    public static class Pos {
        int x;
        int y;
        int d;

        Pos(int x, int y, int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    public static int roll(int idx){
        return (idx+1) % 4;
    }
    public static void setGrid(int[][] grid, List<Pos>list){
        for(Pos p : list) {
            int curX = p.x;
            int curY = p.y;
            grid[curY][curX]++;
        }
    }
    public static List<Pos> setCurve(int x, int y, int g, int d){
        List<Pos> list = new ArrayList<>();
        list.add(new Pos(x,y,d));
        while(g > 0){
            int curX = list.get(list.size()-1).x;
            int curY = list.get(list.size()-1).y;
            int curD = list.get(list.size()-1).d;
            for(int i = list.size()-1; i >= 0; i--) {
                int nextD = roll(list.get(i).d);
                switch (curD) {
                    case 0: {
                        list.add(new Pos(++curX, curY, nextD));
                        break;
                    }
                    case 1: {
                        list.add(new Pos(curX, --curY, nextD));
                        break;
                    }
                    case 2: {
                        list.add(new Pos(--curX, curY, nextD));
                        break;
                    }
                    case 3: {
                        list.add(new Pos(curX, ++curY, nextD));
                        break;
                    }
                }
                curD = nextD;
            }
            g--;
        }
        Pos lastPos = list.get(list.size()-1);
        switch(lastPos.d){
            case 0 : {
                list.add(new Pos(lastPos.x+1,lastPos.y,-1));
                break;
            }
            case 1: {
                list.add(new Pos(lastPos.x,lastPos.y-1,-1));
                break;
            }
            case 2: {
                list.add(new Pos(lastPos.x-1,lastPos.y,-1));
                break;
            }
            case 3 : {
                list.add(new Pos(lastPos.x, lastPos.y+1,-1));
                break;
            }
        }
        return list;
    }
}
