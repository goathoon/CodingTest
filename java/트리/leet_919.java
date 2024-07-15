package 트리;
import java.util.*;

public class leet_919 {

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
    class CBTInserter {
        TreeNode rootNode;
        List<TreeNode> nodeList = new ArrayList<>();
        int curIdx = 0;

        public CBTInserter(TreeNode root) {
            // rootNode를 진작에 저장
            rootNode = root;

            nodeList.add(root);
            curIdx++;
            while(true){
                TreeNode curNode = nodeList.get((curIdx-1) / 2);
                if(curNode.left != null){
                    nodeList.add(curNode.left);
                    curIdx++;
                }
                if(curNode.right != null){
                    nodeList.add(curNode.right);
                    curIdx++;
                    continue;
                }
                break;
            }
        }

        public int insert(int val) {
            TreeNode curNode = nodeList.get((curIdx-1) / 2);

            if(curNode.left == null){
                TreeNode newNode = new TreeNode(val);
                nodeList.add(newNode);
                curNode.left = newNode;
                curIdx++;
            }
            else if(curNode.right == null){
                TreeNode newNode = new TreeNode(val);
                nodeList.add(newNode);
                curNode.right = newNode;
                curIdx++;
            }
            return curNode.val;
        }

        public TreeNode get_root() {
            return nodeList.get(0);
        }
    }

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
}
