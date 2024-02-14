package 이분탐색;
import java.io.*;
import java.util.*;
public class boj_1253 {
    class Main{
        static boolean[] visited;
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            visited = new boolean[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int ans = 0;
            for(int i = 0; i < arr.length; i++){
                for(int j = i+1; j < arr.length; j++){
                    int target = arr[i] + arr[j];

                    int upperBound = getUpperBound(target,arr);
                    int lowerBound = getLowerBound(target,arr);
                    for(int idx = lowerBound; idx < upperBound; idx++){
                        if(idx == i || idx == j) continue;
                        visited[idx] = true;
                    }
                }
            }
            for(int i = 0; i < visited.length; i++){
                if(visited[i]) ans++;
            }
            System.out.println(ans);
        }
        public static int getUpperBound(int target, int[] arr){
            int l = 0, r = arr.length;

            while(l < r){
                int mid = (l+r)/2;
                if(arr[mid] > target) r = mid;
                else if (arr[mid] <= target) l = mid+1;
            }
            return l;
        }

        // 잘 생각해봐.
        // l < r 인 조건하에서, 하계를 구하는 중인데,
        // target과 같거나 큰 원소를 '포함'한 채로 탐색범위를 정해야 하므로, r을 mid르 옮기는 것이다.
        // 반면, target보다 작은 원소는 볼것도 없이 mid+1로 해야, 탐색범위가 줄어든다.
        public static int getLowerBound(int target, int[] arr){
            int l = 0, r = arr.length;
            while(l < r){
                int mid = (l+r)/2;
                if(arr[mid] < target) l = mid+1;
                else r = mid;
            }
            return l;
        }
    }
}
