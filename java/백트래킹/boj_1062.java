package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1062 {
    static int N;
    static int K;
    static String[] strings;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        strings = new String[N];
        for(int n = 0; n < N; n++){
            strings[n] = br.readLine();
        }

        // 먼저 26개중에 5개는 제외,
        // 나머지 21개중에 k-5개 선택하는 경우의 수별로 50개씩 확인
        if(K < 5) {
            System.out.println(0);
            System.exit(0);
        }

        boolean[] visited = new boolean[26];
        boolean[] word = new boolean[26];
        init(word,visited);
        answer = 0;

        dfs(visited,word,0,5);

        System.out.println(answer);
    }
    public static void init(boolean[] word, boolean[] visited){
        word['a'-'a'] = true;
        visited['a'-'a'] = true;
        word['n'-'a'] = true;
        visited['n'-'a'] = true;
        word['t'-'a'] = true;
        visited['t'-'a'] = true;
        word['i'-'a'] = true;
        visited['i'-'a'] = true;
        word['c'-'a'] = true;
        visited['c'-'a'] = true;
    }

    public static void dfs(boolean[] visited, boolean[] word, int idx, int depth){



        if(depth == K){
            int ans = 0;
            for(int n = 0; n < N; n++){
                String s = strings[n];
                boolean flag = true;
                for(int i = 0; i < s.length(); i++){
                    if(!word[s.charAt(i)-'a']){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans++;
                }
            }
            answer = Math.max(answer,ans);
            return;
        }

        if(idx > 25) return;
        // 알파벳 선택하는 조합의 수
        for(int i = idx; i < 26; i++){
            // 알파벳 선택
            if(!visited[i]){
                visited[i] = true;
                word[i] = true;
                dfs(visited,word,i+1,depth+1);
                visited[i] = false;
                word[i] = false;
            }
        }
    }

}
