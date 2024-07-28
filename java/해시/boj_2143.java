package 해시;
import java.io.*;
import java.util.*;
public class boj_2143{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int target = Integer.parseInt(br.readLine());

        int a = Integer.parseInt(br.readLine());
        int[] arr1 = new int[a];
        st = new StringTokenizer(br.readLine() ," ");
        for(int i = 0; i < a; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int b = Integer.parseInt(br.readLine());
        int[] arr2 = new int[b];
        st = new StringTokenizer(br.readLine() ," ");
        for(int i = 0; i < b; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Long> Amap = partSum(arr1);
        Map<Integer, Long> Bmap = partSum(arr2);

        long ans = 0;
        for(int asum : Amap.keySet()){
            if(Bmap.containsKey(target-asum)){
                ans += Amap.get(asum) * Bmap.get(target-asum);
            }
        }

        System.out.println(ans);
    }

    public static Map<Integer, Long> partSum(int[] arr){
        Map<Integer, Long> map = new HashMap<>();
        int[] sum = new int[arr.length+1];
        for(int i = 0; i < arr.length; i++) {
            sum[i+1] = (arr[i] + sum[i]);
        }

        for(int i = 0; i < sum.length; i++) {
            for(int j = i+1; j < sum.length; j++){
                int partSum = sum[j] - sum[i];
                if(Objects.nonNull(map.get(partSum))){
                    map.put(partSum,map.get(partSum)+1);
                }
                else{
                    map.put(partSum,1L);
                }
            }
        }

        return map;
    }
}
