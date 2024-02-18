package 우선순위큐;
import java.util.*;
public class leet_2402 {
    class Solution {
        public int mostBooked(int n, int[][] meetings) {
            int[] rooms = new int[n];
            Arrays.sort(meetings,(arr1,arr2) -> arr1[0] - arr2[0]);
            PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
            for(int i = 0; i < n; i++){
                availableRooms.offer(i);
            }
            PriorityQueue<Task> taskPQ = new PriorityQueue<>();
            // meetings 원소 순환한다.
            // 순환하면서 taskPQ에 하나씩 넣는다. (끝나는 시간이 먼저로 정렬이됨). 그리고 availRooms에서 가장 적은 번호를 할당 받는다.(pq)
            // taskPQ의 가장 첫 원소가 가장 빨리 끝나는 원소이다. 그래서, meetings 원소 순환하면서 시작시간이 taskPQ의 끝나느시간보다 크면 taskPQ poll하고 다시 할당해준다
            // 만일 availRooms가 없다면 가장 첫 원소를 꺼내면 가장 빨리 끝나는 task이므로, 그 시간에 현재 순환하고 있는 meetings 정보를 넣는다.

            for(int i = 0; i < meetings.length;i++){
                int startTime = meetings[i][0];
                int endTime = meetings[i][1];
                int duration = endTime - startTime;
                boolean flag = false;
                while(!taskPQ.isEmpty()){
                    Task t = taskPQ.peek();
                    if(t.endTime <= startTime){
                        taskPQ.poll();
                        availableRooms.offer(t.roomNum);
                    }
                    else break;
                }
                int minRoomNum = -1;
                if(availableRooms.isEmpty()){
                    Task t = taskPQ.poll();
                    availableRooms.offer(t.roomNum);
                    minRoomNum = availableRooms.poll();
                    taskPQ.add(new Task(t.endTime, t.endTime + duration,minRoomNum));
                }
                else{
                    minRoomNum = availableRooms.poll();
                    taskPQ.add(new Task(startTime, endTime, minRoomNum));
                }
                rooms[minRoomNum]++;
            }
            int maxCnt = 0;
            int ans = 0;
            for(int i = 0; i < rooms.length; i++){
                if(maxCnt < rooms[i]){
                    ans = i;
                    maxCnt = rooms[i];
                }
            }
            return ans;
        }
        class Task implements Comparable<Task>{
            int endTime;
            int startTime;
            int roomNum;
            Task(int startTime, int endTime, int roomNum){
                this.endTime = endTime;
                this.startTime = startTime;
                this.roomNum = roomNum;
            }

            public int compareTo(Task t){
                if(this.endTime - t.endTime == 0){
                    return this.roomNum - t.roomNum;
                }
                return this.endTime - t.endTime;
            }
        }
    }
}
