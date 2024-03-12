package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_14891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] wheels = new char[5][8];
        boolean[] visited = new boolean[5];
        wheels[1] = br.readLine().toCharArray();
        wheels[2] = br.readLine().toCharArray();
        wheels[3] = br.readLine().toCharArray();
        wheels[4] = br.readLine().toCharArray();

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int wheelNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            roll(visited,wheels,wheelNum,dir);
            initVisited(visited);
        }
        int answer = 0;
        if(wheels[1][0] == '1') answer += 1;
        if(wheels[2][0] == '1') answer += 2;
        if(wheels[3][0] == '1') answer += 4;
        if(wheels[4][0] == '1') answer += 8;
        System.out.println(answer);
    }
    public static void initVisited(boolean[] visited){
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
    }
    public static void roll(boolean[] visited, char[][] wheels, int wheel, int dir){
        if (wheel == 0 || wheel == 5 || visited[wheel]) return;
        visited[wheel] = true;

        if(wheel < 4 && wheels[wheel][2] != wheels[wheel+1][6]){
            roll(visited,wheels,wheel+1,dir*-1);
        }
        if(wheel > 1 && wheels[wheel][6] != wheels[wheel-1][2]){
            roll(visited,wheels,wheel-1,dir*-1);
        }
        if(dir==1){
            char temp = wheels[wheel][7];
            for(int i = 6; i >= 0; i--){
                wheels[wheel][i+1] = wheels[wheel][i];
            }
            wheels[wheel][0] = temp;

        }
        else if (dir ==-1){
            char temp = wheels[wheel][0];
            for(int i = 1; i <= 7; i++){
                wheels[wheel][i-1] = wheels[wheel][i];
            }
            wheels[wheel][7] = temp;
        }
    }
}
