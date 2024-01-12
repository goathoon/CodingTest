package 우선순위큐;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class pg_디스크컨트롤러 {


    class Solution {
        public int solution(int[][] jobs) {
            int curIdx = 0;
            int sum = 0;
            Arrays.sort(jobs,new ArrComparator());
            Queue<int[]> pq = new PriorityQueue<>(new PqComparator());

            curIdx = 0;
            int curTime;
            if (jobs.length == 1){
                return jobs[0][1] - jobs[0][0];
            }

            while(curIdx < jobs.length){
                curTime = jobs[curIdx][0];
                pq.add(jobs[curIdx++]);

                while(!pq.isEmpty()){
                    int[] curProcess = pq.poll();
                    int reqTime = curProcess[0];
                    int execTime = curProcess[1];
                    sum += curTime - reqTime + execTime;
                    curTime += execTime;

                    while(curIdx < jobs.length && jobs[curIdx][0] <= curTime){
                        pq.add(jobs[curIdx++]);
                    }
                }
            }
            System.out.println(sum);
            return sum / jobs.length;
        }
        static class ArrComparator implements Comparator<int[]> {
            // request 시간이 동일할 경우 작업시간도 정렬을 해주어야 한다.
            public int compare (int[] a1, int[] a2){
                if (a1[0] - a2[0] != 0) return a1[0] - a2[0];
                else return a1[1] - a2[1];
            }
        }
        static class PqComparator implements Comparator<int[]>{
            public int compare(int[] a1, int[] a2){
                return a1[1] - a2[1];
            }
        }
    }
}
