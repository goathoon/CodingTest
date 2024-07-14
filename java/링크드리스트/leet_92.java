package 링크드리스트;
import java.util.*;
public class leet_92 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode[] reversedList = new ListNode[right-left+1];

            int start = 1;
            ListNode cur = head;
            ListNode beforeNode = null;

            // left 시작지점으로 Node 이동
            while(start != left){
                if(start == 1){
                    beforeNode = head;
                }
                else{
                    beforeNode = beforeNode.next;
                }
                cur = cur.next;
                start++;
            }


            // left지점부터 right지점까지 list로 순서대로 저장
            int cnt = 0;
            while(cnt != right-left+1){
                reversedList[cnt++] = new ListNode(cur.val);
                cur = cur.next;
            }


            // 마지막 노드의 다음 노드 기억
            ListNode afterNode = cur;

            // 역순으로 이어 붙이기
            for(int i = reversedList.length-1; i >= 0; i--){
                if(Objects.nonNull(beforeNode)){
                    beforeNode.next = reversedList[i];
                    beforeNode = beforeNode.next;
                }
                else{
                    head = reversedList[i];
                    beforeNode = head;
                }

            }
            beforeNode.next = afterNode;

            return head;
        }
    }
}
