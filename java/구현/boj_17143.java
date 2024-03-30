package 구현;
import java.io.*;
import java.util.*;
public class boj_17143 {
    static class Shark{
        int speed;
        int size;
        int dir;
        boolean isMove = false;
        Shark(int speed, int size, int dir){
            this.speed = speed;
            this.size = size;
            this.dir = dir;
        }
    }
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        List<List<List<Shark>>> grid = new ArrayList<>();
        for(int r = 0; r <= R; r++){
            grid.add(new ArrayList<>());
            for(int c = 0; c <= C; c++){
                grid.get(r).add(new ArrayList<>());
            }
        }
        for(int s = 0; s < S; s++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            grid.get(r).get(c).add(new Shark(speed,size,d));
        }
        int ans = 0;
        for(int c = 0; c+1 < grid.get(0).size(); ){
            c++;
            ans += getShark(c,grid);
            move(grid);
            eat(grid);
            initMove(grid);
        }
        System.out.println(ans);
    }
    public static void initMove(List<List<List<Shark>>> grid){
        for(int r = 1; r< grid.size(); r++){
            for (int c = 1; c<grid.get(0).size(); c++){
                for(Shark s : grid.get(r).get(c)){
                   s.isMove = false;
                }
            }
        }
    }
    public static void move(List<List<List<Shark>>> grid){
        for(int r = 1; r< grid.size(); r++){
            for(int c = 1; c< grid.get(0).size(); c++){
                if(grid.get(r).get(c).size() >= 1){
                    Shark curShark = grid.get(r).get(c).get(0);
                    if(curShark.isMove) continue;
                    int speed = curShark.speed;
                    int dir = curShark.dir;
                    int curRow = r;
                    int curCol = c;
                    while(speed != 0) {
                        speed--;
                        switch (dir) {
                            case 1: { // 위
                                if(curRow == 1){
                                    dir = 2;
                                    curRow = 2;
                                }
                                else{
                                    curRow--;
                                }
                                break;
                            }
                            case 2 : {
                                if(curRow == grid.size()-1){
                                    dir = 1;
                                    curRow = grid.size()-2;
                                }
                                else{
                                    curRow++;
                                }
                                break;
                            }
                            case 3 : {
                                if(curCol == grid.get(0).size()-1){
                                    dir = 4;
                                    curCol = grid.get(0).size()-2;
                                }
                                else{
                                    curCol++;
                                }
                                break;
                            }
                            case 4 : {
                                if(curCol == 1){
                                    dir = 3;
                                    curCol = 2;
                                }
                                else{
                                    curCol--;
                                }
                                break;
                            }
                        }
                    }
                    grid.get(r).get(c).remove(0);
                    Shark updateShark = new Shark(curShark.speed,curShark.size,dir);
                    updateShark.isMove = true;
                    grid.get(curRow).get(curCol).add(updateShark);

                }
            }
        }
    }

    public static void eat(List<List<List<Shark>>>  grid){
        for(int r = 1; r < grid.size(); r++){
            for(int c = 1; c < grid.get(r).size(); c++){
                if(grid.get(r).get(c).size() >= 2){
                    Shark bigShark = null;
                    int maxSize = Integer.MIN_VALUE;
                    for(Shark s : grid.get(r).get(c)) {
                        if(maxSize < s.size){
                            maxSize = s.size;
                            bigShark = s;
                        }
                    }
                    grid.get(r).get(c).clear();
                    grid.get(r).get(c).add(bigShark);
                }
            }
        }
    }
    public static int getShark(int c, List<List<List<Shark>>> grid){
        int res = 0;
        for(int r = 1; r < grid.size(); r++){
            if(grid.get(r).get(c).size() == 1){
               res = grid.get(r).get(c).get(0).size;
               grid.get(r).get(c).clear();
               break;
            }
        }
        return res;
    }
}
