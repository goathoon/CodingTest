package 그리디;
import java.io.*;
import java.util.*;
public class boj_9237 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list,Comparator.reverseOrder());
        int ans = 1;
        for(int i = 0; i < list.size(); i++){
            ans = Math.max(ans, list.get(i) + (i+2));
        }
        System.out.println(ans);

        // Array reverse정렬은 어떻게 할까?
        int [] arr = {1,3,2,-1,5};
        // Arrays.sort(arr,Collections.reverseOrder());
        // 위의 정렬이 되지 않는 이유는 기본적으로 Comparator.reverseOrder(Collections.reverseOrder와 같다) 는 Wrapper Type만 가능하다.
        Integer[] arr2 = {1,3,2,-1,5};
        Arrays.sort(arr2,Comparator.reverseOrder()); //이럼 된다.

    }
}
