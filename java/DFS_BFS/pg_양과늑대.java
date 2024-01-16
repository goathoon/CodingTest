package DFS_BFS;
import java.util.*;
public class pg_양과늑대 {

    class Solution {
        static Node[] nodeArr;
        static int answer = 0;
        static boolean[] visited;
        public int solution(int[] info, int[][] edges) {
            nodeArr = new Node[info.length];
            visited = new boolean[info.length];
            // Node 생성
            for(int i = 0 ; i <info.length; i++){
                nodeArr[i] = new Node();
            }
            for(int[] e : edges){
                if (nodeArr[e[0]].left == -1){
                    nodeArr[e[0]].left = e[1];
                }
                else{
                    nodeArr[e[0]].right = e[1];
                }
            }
            Set<Integer> nextNodes = new HashSet<>();

            dfs(info, 0, nextNodes, 0,0);
            return answer;
        }
        static void dfs(int[] info, int curNode,Set<Integer> nextNodes,int sheep, int pred){
            visited[curNode] = true;
            if(info[curNode] == 1){
                pred++;
            }
            else{
                sheep++;
                answer = Math.max(sheep,answer);
            }
            if (sheep == pred) return;

            if(nodeArr[curNode].left != -1) nextNodes.add(nodeArr[curNode].left);
            if(nodeArr[curNode].right != -1) nextNodes.add(nodeArr[curNode].right);

            for(int n : nextNodes){
                Set<Integer>cloneSet = new HashSet<>(nextNodes);
                cloneSet.remove(n);
                dfs(info,n,cloneSet,sheep,pred);
            }
        }

    }
    class Node{
        int left = -1;
        int right = -1;
        Node(){

        }
    }
}
