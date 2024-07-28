package 백트래킹;
import java.io.*;
import java.util.*;
public class boj_6987 {
    /**
     * 총 15번의 경기
     * 3^15 경우를 전체 탐색하면서 주어진 조건에 만족하는지 확인하면 된다.
     * 최종 시간복잡도는 3^15 * 4 가 되겠다.
     */

    static class TeamScore {
        int win;
        int draw;
        int lose;
        TeamScore() {
        }
    }

    static TeamScore[] teams;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        teams = new TeamScore[6];

        // 6팀의 대진 결과를 담을 배열 (이기면 3, 비기면 2, 지면 1)
        int[][] check = new int[6][6];
        for(int i = 0; i < 4; i++){
            initCheck(check);
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 6; j++){
                teams[j] = new TeamScore();
                int win = Integer.parseInt(st.nextToken());
                int draw = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());
                teams[j].win = win;
                teams[j].draw = draw;
                teams[j].lose = lose;

            }
            if(dfs(check,0)){
                System.out.printf("%d ", 1);
            }
            else{
                System.out.printf("%d ", 0);
            }
        }

    }
    public static boolean dfs(int[][] check, int depth){
//        System.out.println(depth + " " + Arrays.deepToString(check));
        if(depth >= 36){
            for(int i = 0; i < 6; i++){
                int win = 0;
                int draw = 0;
                int lose = 0;
                for(int j = 0; j < 6; j++){
                    if(i == j) continue;
                    if(check[i][j] == 3){
                        win++;
                    }
                    else if(check[i][j] == 2){
                        draw++;
                    }
                    else if(check[i][j] == 1){
                        lose++;
                    }
                }
                if(!(teams[i].win == win && teams[i].draw == draw && teams[i].lose == lose)){
                    return false;
                }
            }
            return true;
        }

        boolean result = false;

        int i = depth / 6;
        int j = depth % 6;

        if(i == j || check[i][j] != 0) {
            result |= dfs(check,i*6+j +1);
        }
        else {
            check[i][j] = 3;
            check[j][i] = 1;
            result |= dfs(check, i * 6 + j + 1);
            check[i][j] = 0;
            check[j][i] = 0;

            check[i][j] = 2;
            check[j][i] = 2;
            result |= dfs(check, i * 6 + j + 1);
            check[i][j] = 0;
            check[j][i] = 0;

            check[i][j] = 1;
            check[j][i] = 3;
            result |= dfs(check, i * 6 + j + 1);
            check[i][j] = 0;
            check[j][i] = 0;
        }
        if (result) {
            return true;
        }
        return false;
    }

    public static void initCheck(int[][] check){
        for(int i = 0; i < check.length; i++){
            for(int j = 0; j < check[0].length; j++){
                check[i][j] = 0;
            }
        }
    }
}
