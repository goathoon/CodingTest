package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][N];
        List<int[]> list = new ArrayList<>();

        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c <N; c++){
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
            list.add(grid[r]);
        }
        for(int c = 0; c < N; c++){
            int[] arr = new int[N];
            for(int r = 0; r < N; r++){
                arr[r] = grid[r][c];
            }
            list.add(arr);
        }
        int ans = 0;
        Loop : for(int[] arr : list){
            int cnt = 0;
            int before = -1;
            boolean[] isVisit = new boolean[arr.length];
            for(int i = 0; i < arr.length; i++){
                if(i==0){
                    before = arr[i];
                    cnt = 1;
                }
                else{
                    if(before == arr[i]){
                        cnt++;
                    }
                    else if(Math.abs(before-arr[i]) >= 2){
                        continue Loop;
                    }
                    else if (before > arr[i]){
                        before = arr[i];
                        cnt = 1;
                        if(arr.length-i >= L){
                            for(int j = i; j <= i+L-1; j++){
                                if(arr[j] != arr[i]){
                                    continue Loop;
                                }
                                isVisit[j] = true;
                            }
                        }
                        else continue Loop;
                    }
                    else{
                        if(cnt < L) continue Loop;
                        for(int j = i-1; j >= i-L; j--){
                            if(isVisit[j]) continue Loop;
                        }
                        before = arr[i];
                        cnt = 1;
                    }
                }

            }
//            System.out.println(Arrays.toString(arr));
            ans++;
        }
        System.out.println(ans);
    }
}
