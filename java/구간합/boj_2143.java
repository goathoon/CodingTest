package 구간합;
import java.io.*;
import java.util.*;
public class boj_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long target = Long.parseLong(br.readLine());

        int a = Integer.parseInt(br.readLine());
        long[] A = new long[a];
        st = new StringTokenizer(br.readLine(), " ");
        for(int n = 0; n < a; n++){
            A[n] = Long.parseLong(st.nextToken());
        }

        int b = Integer.parseInt(br.readLine());
        long[] B = new long[b];
        st = new StringTokenizer(br.readLine(), " ");
        for(int n = 0; n < b; n++){
            B[n] = Long.parseLong(st.nextToken());
        }

        List<Long> aList = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            long cur = A[i];
            aList.add(cur);
            for(int j = i+1; j < A.length; j++){
                cur += A[j];
                aList.add(cur);
            }
        }
        List<Long> bList = new ArrayList<>();
        for(int i = 0; i < B.length; i++){
            long cur = B[i];
            bList.add(cur);
            for(int j = i+1; j < B.length; j++){
                cur += B[j];
                bList.add(cur);
            }
        }

        Collections.sort(bList);

        long ans = 0;
        for(int i = 0; i < aList.size(); i++){
            long cur = aList.get(i);
            int lowerIdx = lowerBound(bList, cur, target);
            int upperIdx = upperBound(bList, cur, target);
            ans += upperIdx - lowerIdx;
        }
        System.out.println(ans);
    }

    public static int lowerBound(List<Long> list, long cur, long target){
        int l = 0, r = list.size();
        while(l < r){
            int mid = (l+r)/2;
            if(list.get(mid) + cur >= target){
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
        return l;
    }
    public static int upperBound(List<Long> list, long cur, long target){
        int l = 0, r = list.size();
        while(l < r){
            int mid = (l+r)/2;
            if(list.get(mid) + cur > target){
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
        return l;
    }
}
