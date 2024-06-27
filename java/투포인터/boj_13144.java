package 투포인터;
import java.io.*;
import java.util.*;
public class boj_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        long ans = 0;
        int start = 0;
        for(int i = 0; i < N; i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            }
            else{

                while(true){
                    if(arr[start] == arr[i]){
                        //이미 arr[i]는 set에 포함되어있으므로 삭제할 필요 x
                        ans += i-start;
                        start++;
                        break;
                    }
                    else{
                        // 중복은 됐는데, 처음 숫자랑 마지막 문자가 다른 경우에는, 처음 숫자 단독으로 만들 수 있는 숫자배열 수 를 ans에 추가
                        ans += i - start;
                        set.remove(arr[start++]);
                    }
                }
            }

        }
        while(start != N){
            ans += N-start;
            start++;
        }
        System.out.println(ans);
    }
}
