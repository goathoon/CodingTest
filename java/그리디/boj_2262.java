package 그리디;
import java.io.*;
import java.util.*;
public class boj_2262 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int max = N;
        int ans = 0;
        while(list.size() != 1){
            int maxIdx = list.indexOf(max);
            // 끝 index인 경우
            if(maxIdx == list.size()-1){
                ans += max - list.get(maxIdx-1);
                list.remove(maxIdx);
            }
            else if (maxIdx == 0){
                ans += max - list.get(1);
                list.remove(0);
            }
            else{
                int before = list.get(maxIdx-1);
                int next = list.get(maxIdx+1);
                if(before < next){
                    ans += max - next;
                }
                else{
                    ans += max - before;
                }
                list.remove(maxIdx);
            }
            max--;
        }
        System.out.println(ans);
    }
}
