package 구현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class boj_13460 {
    static char[][] grid;
    static Pos redPos = null;
    static Pos bluePos = null;
    static Pos target = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        grid = new char[row][col];
        redPos = null;
        bluePos = null;
        target = null;
        for(int r = 0; r < row; r++){
            String s = sc.next();
            for(int c = 0; c < col; c++){
                grid[r][c] = s.charAt(c);
                switch(grid[r][c]){
                    case 'R' : redPos = new Pos(r,c); break;
                    case 'B' : bluePos = new Pos(r,c); break;
                    case 'O' : target = new Pos(r,c); break;
                    default : break;
                }
            }
        }
        Queue<RedBlue> q = new LinkedList<>();
        q.add(new RedBlue(redPos,bluePos,0));
        while (!q.isEmpty()){
            RedBlue rb = q.poll();
            Pos curRed = rb.red;
            Pos curBlue = rb.blue;
            int curCnt = rb.cnt;
            if(curCnt >= 10){
                System.out.println(-1);
                return;
            }
            for(int i = 0; i < 4; i++){
                int curRedC = curRed.c;
                int curRedR = curRed.r;
                int curBlueC = curBlue.c;
                int curBlueR = curBlue.r;
                if(!isBlueReach(i,curBlue)){
                    switch(i){
                        case 0 : {
                            while(grid[curRedR][curRedC+1] != '#'){
                                curRedC += 1;
                            }
                            while(grid[curBlueR][curBlueC+1] != '#'){
                                curBlueC += 1;
                            }
                            if(curRedR == curBlueR && curRedC == curBlueC){
                                if(curRed.c < curBlue.c){
                                    curRedC = curBlueC - 1;
                                }
                                else{
                                    curBlueC = curRedC - 1;
                                }
                            }

                            if(curRedR == target.r && curRedC >= target.c && curRed.c < target.c){
                                System.out.println(curCnt + 1);
                                return;
                            }
                            q.add(new RedBlue(new Pos(curRedR,curRedC),new Pos(curBlueR,curBlueC), curCnt + 1));
                            break;
                        }
                        case 1 : {
                            while(grid[curRedR][curRedC-1] != '#'){
                                curRedC -= 1;
                            }
                            while(grid[curBlueR][curBlueC-1] != '#'){
                                curBlueC -= 1;
                            }
                            if(curRedR == curBlueR && curRedC == curBlueC){
                                if(curRed.c < curBlue.c){
                                    curBlueC = curRedC + 1;
                                }
                                else{
                                    curRedC = curBlueC + 1;
                                }
                            }
                            if(curRedR == target.r && curRedC <= target.c && curRed.c > target.c){
                                System.out.println(curCnt + 1);
                                return;
                            }
                            q.add(new RedBlue(new Pos(curRedR,curRedC),new Pos(curBlueR,curBlueC), curCnt + 1));
                            break;
                        }
                        case 2 :{

                            while(grid[curRedR-1][curRedC] != '#'){
                                curRedR -= 1;
                            }
                            while(grid[curBlueR-1][curBlueC] != '#'){
                                curBlueR -= 1;
                            }
                            if(curRedR == curBlueR && curRedC == curBlueC){
                                if(curRed.r < curBlue.r){
                                    curBlueR = curRedR + 1;
                                }
                                else{
                                    curRedR = curBlueR + 1;
                                }
                            }
                            if(curRedC == target.c && curRedR <= target.r && curRed.r > target.r){
                                System.out.println(curCnt + 1);
                                return;
                            }
                            q.add(new RedBlue(new Pos(curRedR,curRedC),new Pos(curBlueR,curBlueC),curCnt + 1));
                            break;
                        }
                        case 3 :{

                            while(grid[curRedR+1][curRedC] != '#'){
                                curRedR += 1;
                            }
                            while(grid[curBlueR+1][curBlueC] != '#'){
                                curBlueR += 1;
                            }
                            if(curRedR == curBlueR && curRedC == curBlueC){
                                if(curRed.r < curBlue.r){
                                    curRedR = curBlueR - 1;
                                }
                                else{
                                    curBlueR = curRedR - 1;
                                }
                            }
                            if(curRedC == target.c && curRedR >= target.r && curRed.r < target.r){
                                System.out.println(curCnt + 1);
                                return;
                            }
                            q.add(new RedBlue(new Pos(curRedR,curRedC),new Pos(curBlueR,curBlueC),curCnt + 1));
                            break;
                        }
                    }
                }
            }

        }

    }
    static boolean isBlueReach(int i,Pos blue){
        int blueR = blue.r;
        int blueC = blue.c;
        switch(i){
            //오른쪽
            case 0 : {
                if (blue.r == target.r ){
                    while(grid[blueR][blueC] != '#') {
                        blueC += 1;
                    }
                    if(blueC >= target.c && blue.c < target.c) return true;
                }
                break;
            }
            //왼쪽
            case 1 : {
                if (blue.r == target.r){
                    while(grid[blueR][blueC] != '#') {
                        blueC -= 1;
                    }
                    if(blueC <= target.c && blue.c > target.c) return true;
                }
                break;
            }
            //위로
            case 2 :{
                if(blue.c == target.c){
                    while(grid[blueR][blueC] != '#') {
                        blueR -= 1;
                    }
                    if(blueR <= target.r && blue.r > target.r) return true;
                }
                break;
            }
            case 3 : {
                if(blue.c == target.c){
                    while(grid[blueR][blueC] != '#') {
                        blueR += 1;
                    }
                    if(blueR >= target.r && blue.r < target.r) return true;
                }
                break;
            }
            default : break;
        }
        return false;
    }
    static class Pos{
        int r;
        int c;
        Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static class RedBlue{
        Pos red;
        Pos blue;
        int cnt;
        RedBlue(Pos red, Pos blue,int cnt){
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
        }
    }
}
