package 구현;
import java.io.*;
import java.util.*;
public class boj_16936 {
    static class Node{
        Long prev;
        Long next;
        Node(){

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long [] arr = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<Long,Node> map = new HashMap<>();
        for(int i = 0 ; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
            map.put(arr[i], new Node());
        }

        for(int i = 0; i < N; i++){
            Node n = map.get(arr[i]);
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(arr[i] * 3 == arr[j]){
                    n.prev = arr[j];
                    map.get(arr[j]).next = arr[i];
                }
                else if(arr[i] * 2 == arr[j]){
                    n.next = arr[j];
                    map.get(arr[j]).prev = arr[i];
                }
            }
        }

        long start = 0;

        StringBuilder sb = new StringBuilder();
        for(long x : map.keySet()){
            if(Objects.isNull(map.get(x).prev)){
                start = x;
                sb.append(start).append(" ");
            }
        }

        while(Objects.nonNull(map.get(start).next)){
            start = map.get(start).next;
            sb.append(start).append(" ");
        }
        System.out.println(sb);
    }

}
