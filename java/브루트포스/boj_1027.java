package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int build[] = new int[N];
        for(int i = 0; i < N; i++){
            build[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 0; i < N; i++){
            //왼쪽
            int l = left(build,i);
            //오른쪽
            int r = right(build,i);
            ans = Math.max(l+r,ans);
        }
        System.out.println(ans);
    }
    public static int left(int[] build, int idx){
        // 항상 기울기가 더 작은것만 볼 수 있음
        float a = Float.MAX_VALUE;
        int ans = 0;
        for(int i = idx-1; i >= 0; i--){
            if (a > (float)(build[idx]-build[i])/(idx-i)){
                a = (float)(build[idx]-build[i])/(idx-i);
                ans++;
            }
        }
        return ans;
    }
    public static int right(int[] build, int idx){
        // 항상 기울기가 더 큰 것만 볼 수 있음
        float a = -Float.MAX_VALUE;
        int ans = 0;
        for(int i = idx+1; i < build.length; i++){
            if (a < (float)(build[idx]-build[i])/(idx-i)){
                a = (float)(build[idx]-build[i])/(idx-i);
                ans++;
            }
        }
        return ans;
    }
}
