package 구현;
import java.io.*;
import java.util.*;
public class EX_상하좌우2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int r = 1, c = 1;
        int[] drow = {0,0,-1,1};
        int[] dcol = {-1,1,0,0};
        char[] move = {'L','R','U','D'};
        String[] moves = br.readLine().split(" ");
        for(String m : moves){
            for(int i = 0; i < 4; i++){
                if(m.charAt(0) == move[i]){
                    int nextR = r + drow[i];
                    int nextC = c + dcol[i];
                    if(nextR <= 0 || nextR > N || nextC <= 0 || nextC > N) continue;
                    r = nextR;
                    c = nextC;
                }
            }
        }
        System.out.println(r + " " + c);

    }
}
