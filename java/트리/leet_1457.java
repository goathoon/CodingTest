package 트리;
import java.util.*;
public class leet_1457 {

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        static int answer;
        public int pseudoPalindromicPaths (TreeNode root) {
            answer = 0;
            LinkedList<Integer> list = new LinkedList<Integer>();
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 1; i <= 9; i ++){
                map.put(i,0);
            }
            map.put(root.val,1);
            list.add(root.val);
            dfs(root, list,map);
            return answer;

        }
        static void dfs(TreeNode curNode, LinkedList<Integer> list, Map<Integer, Integer> map){
            if(Objects.isNull(curNode.left) && Objects.isNull(curNode.right)) {
                int oddCnt = 0;
                for(int x : map.keySet()){
                    if (map.get(x) % 각2 == 1){
                        oddCnt ++;
                    }
                }
                if(list.size() % 2 ==0){
                    if (oddCnt > 0) return;
                }
                else {
                    if (oddCnt != 1) return;
                }
                answer ++;
                return;
            }

            if (Objects.nonNull(curNode.left)){
                list.add(curNode.left.val);
                map.put(curNode.left.val, map.get(curNode.left.val) + 1);
                dfs(curNode.left, list, map);
                list.removeLast();
                map.put(curNode.left.val, map.get(curNode.left.val) - 1);
            }
            if (Objects.nonNull(curNode.right)){
                list.add(curNode.right.val);
                map.put(curNode.right.val, map.get(curNode.right.val) + 1);
                dfs(curNode.right, list,map);
                list.removeLast();
                map.put(curNode.right.val, map.get(curNode.right.val) - 1);
            }
        }
    }
}


/** 아래는 TLE의 코드
 * class Solution {
 *     static int answer;
 *     public int pseudoPalindromicPaths (TreeNode root) {
 *         answer = 0;
 *         List<Integer> list = new LinkedList<Integer>();
 *         list.add(root.val);
 *         dfs(root, list);
 *         return answer;
 *
 *     }
 *     static void dfs(TreeNode curNode, List<Integer> list){
 *         if(Objects.isNull(curNode.left) && Objects.isNull(curNode.right)) {
 *             if(isPal(list)) answer ++;
 *             return;
 *         }
 *         if (Objects.nonNull(curNode.left)){
 *             list.add(curNode.left.val);
 *             dfs(curNode.left, list);
 *             list.removeLast();
 *         }
 *         if (Objects.nonNull(curNode.right)){
 *             list.add(curNode.right.val);
 *             dfs(curNode.right, list);
 *             list.removeLast();
 *         }
 *     }
 *     static boolean isPal(List<Integer> arr){
 *         int oddCnt = 0;
 *         Map<Integer,Integer> map = new HashMap<>();
 *         for(int x : arr){
 *             if(Objects.isNull(map.get(x))){
 *                 map.put(x,1);
 *                 continue;
 *             }
 *             map.put(x, map.get(x)+1);
 *         }
 *         for(int x : map.keySet()){
 *             if (map.get(x) % 2 == 1){
 *                 oddCnt ++;
 *             }
 *         }
 *         if(arr.size() % 2 ==0){
 *             if (oddCnt > 0) return false;
 *         }
 *         else {
 *             if (oddCnt != 1) return false;
 *         }
 *         return true;
 *     }
 * }
 */