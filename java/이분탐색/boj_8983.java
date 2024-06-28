package 이분탐색;
import java.io.*;
import java.util.*;
public class boj_8983 {
    static class Animal{
        int x;
        int y;
        Animal(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        Animal[] animals = new Animal[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            animals[i] = new Animal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int ans = 0;

        for(int i = 0; i < N; i++){
            int ax = animals[i].x;
            int ay = animals[i].y;
            int width = L - ay;

            int leftWidth = ax - width;
            int rightWidth = ax + width;

            int l = 0, r = arr.length;
            while(l < r){
                int mid = (l+r) / 2;
                if(leftWidth <= arr[mid] && arr[mid] <= rightWidth){
                    ans++;
                    break;
                }
                else if(leftWidth > arr[mid]){
                    l = mid+1;
                }
                else {
                    r = mid;
                }
            }
        }
        System.out.println(ans);
    }
}
