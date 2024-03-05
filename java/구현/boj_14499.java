package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14499 {
    static int[] dice = new int[]{0,0,0,0,0,0};
    static int[][] grid;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        int moves = Integer.parseInt(st.nextToken());
        grid = new int[row][col];
        for(int r = 0; r < row; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < col; c++){
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Loop : for(int i = 0; i < moves; i++){
            int dir = Integer.parseInt(st.nextToken());
            switch(dir){
                case 1 :{
                    if (startCol +1 == grid[0].length) continue Loop;
                    startCol += 1;
                    break;
                }
                case 2: {
                    if(startCol -1 == -1) continue Loop;
                    startCol -= 1;
                    break;
                }
                case 3 : {
                    if(startRow -1 == -1) continue Loop;
                    startRow -= 1;
                    break;
                }
                case 4 : {
                    if(startRow +1 == grid.length) continue Loop;
                    startRow += 1;
                    break;
                }
            }
            turn(dir);
            if(grid[startRow][startCol] == 0){
                grid[startRow][startCol] = dice[5];
            }else{
                dice[5] = grid[startRow][startCol];
                grid[startRow][startCol] = 0;
            }
            System.out.println(dice[0]);
        }
    }
    static void turn(int dir){
        switch(dir){
            case 1 :{
                int temp1 = dice[0];
                dice[0] = dice[2];
                int temp2 = dice[3];
                dice[3] = temp1;
                int temp3 = dice[5];
                dice[5] = temp2;
                dice[2] = temp3;
                break;
            }
            case 2 :{
                int temp1 = dice[0];
                dice[0] = dice[3];
                int temp2 = dice[2];
                dice[2] = temp1;
                int temp3 = dice[5];
                dice[5] = temp2;
                dice[3] = temp3;
                break;
            }
            case 3 : {
                int temp1 = dice[0];
                dice[0] = dice[4];
                int temp2 = dice[1];
                dice[1] = temp1;
                int temp3 = dice[5];
                dice[5] = temp2;
                dice[4] = temp3;
                break;
            }
            case 4 :{
                int temp1 = dice[0];
                dice[0] = dice[1];
                int temp2 = dice[4];
                dice[4] = temp1;
                int temp3 = dice[5];
                dice[5] = temp2;
                dice[1] = temp3;
                break;
            }
        }
    }
}
