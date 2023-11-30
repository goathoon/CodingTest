package 트리;
import java.io.*;
public class boj_5639 {
    static class Node{
        int val;
        Node left = null;
        Node right = null;

        Node(int val){
            this.val = val;

        }

        void insert(int newValue) {
            if (newValue < this.val) {
                if (this.left == null){
                    this.left = new Node(newValue);
                }
                else{
                    this.left.insert(newValue);
                }
            }
            else{
                if (this.right == null){
                    this.right = new Node(newValue);
                }
                else{
                    this.right.insert(newValue);
                }
            }
        }
    }
    static class BinaryTree{
        static Node rootNode;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rootVal = Integer.parseInt(br.readLine());
        Node rootNode = new Node(rootVal);
        BinaryTree.rootNode = rootNode;

        String value;
        while ((value = br.readLine()) != null && !value.isEmpty()) {
            rootNode.insert(Integer.parseInt(value));
        }
        dfs(BinaryTree.rootNode);
    }

    static void dfs(Node node){
        if (node != null){
            dfs(node.left);
            dfs(node.right);
            System.out.println(node.val);
        }
    }
}
