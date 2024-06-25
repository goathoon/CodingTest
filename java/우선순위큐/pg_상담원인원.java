package 우선순위큐;
import java.util.*;

public class pg_상담원인원 {
    static List<int[]> list = new ArrayList<>();
    static List<PriorityQueue<Integer>> mentoQ = new ArrayList<>();

    public int solution(int k, int n, int[][] reqs) {
        // 멘토 분배
        dfs(1,n,k,n,new int[k+1]);
        int answer = Integer.MAX_VALUE;

        for(int[] arr : list){
            mentoQ.clear();
            initMentoQ(k);

            int wait = 0;
            // 각 상담별로 멘토 pq로 할당
            // 멘토 할당이 꽉 차있을 경우 제거
            for(int[] req : reqs){
                int type = req[2];
                int start = req[0];
                int duration = req[1];
                if(mentoQ.get(type).size() < arr[type]){
                    mentoQ.get(type).offer(start+duration);
                }
                else{
                    int endTime = mentoQ.get(type).poll();
                    if(endTime <= start){
                        mentoQ.get(type).offer(start+duration);
                    }
                    else{
                        wait += endTime - start;
                        mentoQ.get(type).offer(endTime+duration);
                    }
                }
            }
            answer = Math.min(wait,answer);
        }
        return answer;
    }
    public static void initMentoQ(int k){
        for(int j = 0; j <= k; j++){
            mentoQ.add(new PriorityQueue<Integer>());
        }
    }

    // n명의 멘토가 k의 상담을 나누는 경우
    public static void dfs(int idx, int n, int k, int remain, int[] arr){
        if(idx == arr.length){
            if(remain > 0){
                return;
            }
            int[] newArr = new int[k+1];
            int i = 1;
            for(int ii = 1; ii < arr.length; ii++){
                newArr[i++] = arr[ii];
            }
            list.add(newArr);
            return;
        }
        if(remain <= 0) return;

        for(int i = 1; i <= remain; i++){
            arr[idx] = i;
            dfs(idx+1,n,k,remain-i,arr);
        }
    }
}
