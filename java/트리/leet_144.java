package 트리;
import java.util.*;
public class leet_144 {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if(Objects.nonNull(root)){
                dfs(root,list);
            }
            return list;
        }

        public void dfs(TreeNode root, List<Integer> list){
            list.add(root.val);
            if(Objects.nonNull(root.left)){
                dfs(root.left,list);
            }
            if(Objects.nonNull(root.right)){
                dfs(root.right,list);
            }
        }
    }
}
