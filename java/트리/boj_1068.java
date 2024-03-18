package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1068 {
    static int answer = 0;
    static class Node{
        int num;
        Set<Integer> child = new HashSet<>();
        Node(int num){
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < N; i++){
            nodes.add(new Node(i));
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int rootNum = 0;
        for(int i = 0; i < N; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                rootNum = i;
                continue;
            }
            nodes.get(parent).child.add(i);
        }
        int remove = Integer.parseInt(br.readLine());
        if(remove == rootNum){
            System.out.println(0);
            return;
        }
        for(int i = 0; i < N; i++){
            if(nodes.get(i).child.contains(remove)){
                nodes.get(i).child.remove(remove);
                break;
            }
        }
        dfs(nodes,rootNum);
        System.out.println(answer);
    }
    public static void dfs(List<Node> nodes, int root){
        Node curNode = nodes.get(root);
        if(curNode.child.size() == 0){
            answer++;
            return;
        }
        for(int nextNode : nodes.get(curNode.num).child){
            dfs(nodes,nextNode);
        }
    }
}
