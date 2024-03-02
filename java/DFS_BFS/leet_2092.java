package DFS_BFS;
import java.util.*;
public class leet_2092 {
    class Solution {
        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            Map<Integer,List<int[]>> timeWithPeople = new TreeMap<>();
            for(int i = 0; i < meetings.length; i++){
                int p1 = meetings[i][0], p2 = meetings[i][1], t = meetings[i][2];
                timeWithPeople.computeIfAbsent(t,k -> new ArrayList<>()).add(new int[]{p1,p2});
                // if(!timeWithPeople.containsKey(t)){
                //     List<int[]> addList = new ArrayList<>();
                //     addList.add(new int[]{p1,p2});
                //     timeWithPeople.put(t, addList);
                // }
                // else{
                //     timeWithPeople.get(t).add(new int[] {p1,p2});
                // }
            }

            boolean[] knowPeople = new boolean[n];
            knowPeople[0] = true;
            knowPeople[firstPerson] = true;
            for(int t : timeWithPeople.keySet()){
                Map<Integer, List<Integer>> meet = new HashMap<>();
                Set<Integer> knowSet = new HashSet<>();
                for(int[] m : timeWithPeople.get(t)){
                    int p1 = m[0], p2 = m[1];
                    meet.computeIfAbsent(p1, k-> new ArrayList<>()).add(p2);
                    meet.computeIfAbsent(p2, k-> new ArrayList<>()).add(p1);

                    // if(meet.containsKey(p1)){
                    //     meet.get(p1).add(p2);
                    // }
                    // else{
                    //     List<Integer> list = new LinkedList<>();용
                    //     list.add(p2);
                    //     meet.put(p1,list);
                    // }
                    // if(meet.containsKey(p2)){
                    //     meet.get(p2).add(p1);
                    // }
                    // else{
                    //     List<Integer> list = new LinkedList<>();
                    //     list.add(p1);
                    //     meet.put(p2,list);
                    // }

                    if(knowPeople[p1]){
                        knowSet.add(p1);
                    }
                    if(knowPeople[p2]){
                        knowSet.add(p2);
                    }
                }
                Queue<Integer> q = new LinkedList<>(knowSet);
                while(!q.isEmpty()){
                    int curP = q.poll();
                    for(int nextP : meet.get(curP)){
                        if(!knowPeople[nextP]){
                            knowPeople[nextP] = true;
                            q.add(nextP);
                        }

                    }
                }
            }
            List<Integer> answer = new LinkedList<>();
            for(int i = 0; i < knowPeople.length; i++){
                if(knowPeople[i]){
                    answer.add(i);
                }
            }
            return answer;


        }
    }
}
