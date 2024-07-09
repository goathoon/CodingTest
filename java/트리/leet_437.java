package 트리;
import java.util.*;
public class leet_437 {

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
        static int ans = 0;
        public int pathSum(TreeNode root, int targetSum) {
            ans = 0;
            if(Objects.nonNull(root)){
                dfs(root, targetSum, new ArrayList<>());
            }
            return ans;
        }
        public void dfs(TreeNode root, int targetSum, List<Long> list){
            List<Long> newList = new ArrayList<>();
            for(long x : list){
                long updateNum = x + root.val;
                if(updateNum == targetSum){
                    ans++;
                }
                newList.add(updateNum);
            }
            if(root.val == targetSum){
                ans++;
                System.out.println(root.val + " ??");
            }
            newList.add((long)root.val);

            if(Objects.nonNull(root.left)){
                dfs(root.left,targetSum,newList);
            }
            if(Objects.nonNull(root.right)){
                dfs(root.right,targetSum,newList);
            }
        }
    }
}
