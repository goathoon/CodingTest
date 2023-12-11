package 링크드리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20055 {
    static int curK = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        Node upCurNode = new Node(Integer.parseInt(st.nextToken()));
        LinkedList upLL = new LinkedList();
        upLL.head = upCurNode;
        for(int i = 1; i < N; i++){
            upCurNode.next = new Node(Integer.parseInt(st.nextToken()));
            upCurNode.next.prev = upCurNode;
            upCurNode = upCurNode.next;
        }
        upLL.tail = upCurNode;

        Node downCurNode = new Node(Integer.parseInt(st.nextToken()));
        LinkedList downLL = new LinkedList();
        downLL.head = downCurNode;
        for(int i = 1; i < N; i++){
            downCurNode.next = new Node(Integer.parseInt(st.nextToken()));
            downCurNode.next.prev = downCurNode;
            downCurNode = downCurNode.next;
        }
        downLL.tail = downCurNode;

        int answer = 0;
        while(true){
            answer ++;
            moveRail(upLL,downLL);
            moveRobot(upLL);
            if(upLL.head.value >= 1){
                upLL.head.isRobot = true;
                upLL.head.value -= 1;
                if(upLL.head.value == 0){
                    curK ++;
                }
            }
            if (curK >= K){
                break;
            }
        }
        System.out.println(answer);
    }

    static class Node{
        int value;
        boolean isRobot = false;
        Node next = null;
        Node prev = null;
        Node(int val){
            this.value = val;
        }
    }

    static class LinkedList{
        Node head = null;
        Node tail = null;
        Node removeTail(){
            Node returnNode = this.tail;
            this.tail = this.tail.prev;
            this.tail.next = null;
            returnNode.prev = null;
            return returnNode;
        }
        void appendHead(Node newNode){
            this.head.prev = newNode;
            newNode.next = this.head;
            newNode.prev = null;
            this.head = newNode;
        }
    }
    static void moveRail(LinkedList up, LinkedList down){
        Node downNode = up.removeTail();
        down.appendHead(downNode);

        Node upNode = down.removeTail();
        up.appendHead(upNode);
        if(up.tail.isRobot) up.tail.isRobot = false;
    }

    static void moveRobot(LinkedList up){
        Node curNode = up.tail.prev;
        while(curNode != null){
            if (curNode.isRobot){
                if (!curNode.next.isRobot && curNode.next.value >= 1 ){
                    curNode.isRobot = false;
                    curNode.next.isRobot = true;
                    curNode.next.value -= 1;
                    if (curNode.next.value == 0){
                        curK ++;
                    }
                    if (up.tail == curNode.next){
                        curNode.next.isRobot = false;
                    }
                }
            }
            curNode = curNode.prev;
        }
    }
}
