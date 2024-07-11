package 위상정렬;
import java.util.*;
public class leet_207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Queue<Integer> courses = new LinkedList<>();

            List<Set<Integer>> list = new ArrayList<>();
            int[] indegree = new int[numCourses];

            for(int i = 0; i < numCourses; i++){
                list.add(new HashSet<>());
            }

            for(int[] x : prerequisites){
                int first = x[1];
                int next = x[0];
                indegree[next] += 1;
                list.get(first).add(next);
            }

            for(int i = 0; i < numCourses; i++){
                if(indegree[i] == 0){
                    courses.offer(i);
                }
            }

            int cnt = 0;

            while(!courses.isEmpty()){
                int curCourse = courses.poll();
                cnt++;
                for(int next: list.get(curCourse)){
                    indegree[next]--;
                    if(indegree[next] == 0){
                        courses.offer(next);
                    }
                }
            }

            if(cnt == numCourses){
                return true;
            }
            return false;
        }
    }
}
