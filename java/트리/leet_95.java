package 트리;
import java.util.*;
public class leet_95 {

     // Definition for a binary tree node.
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
        public List<TreeNode> generateTrees(int n) {
            return makeSubTrees(1,n);
        }

        public List<TreeNode> makeSubTrees(int start, int end) {
            List<TreeNode> trees = new ArrayList<>();

            if(start == end) {
                trees.add(new TreeNode(start));
                return trees;
            }
            if(start > end) {
                trees.add(null);
                return trees;
            }

            for(int root = start; root <= end; root++) {
                List<TreeNode> leftTree = makeSubTrees(start,root-1);
                List<TreeNode> rightTree = makeSubTrees(root+1,end);

                for(TreeNode lt : leftTree){
                    for(TreeNode rt : rightTree){
                        TreeNode n = new TreeNode(root);
                        n.left = lt;
                        n.right = rt;
                        trees.add(n);
                    }
                }
            }

            return trees;
        }
    }
}
