# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

#return l1 하면, [2,4,3] 의 배열형태로 존재
#l1.next= listNode(5)하면 [2,5]가 됨.
#l1 자체를 출력하면 모든 linked list들이 줄지어 프린트됨 (traverse)
#print(l1.val)하면 int가 출력됨
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """ 
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        result = ListNode()
        head = result #맨처음 노드는 저장해야함. 나중에 return 해야 하므로
        # curr = result.next 
        addUp = 0
        while(l1 is not None or l2 is not None): # 각 LinkedList 모두 none이 아닐경우 계산
            # next로 이동하여 l1 l2 덧셈 진행한 결과를 자릿수별로 저장
            # 이전 결과로 나온, addUp을 고려한채 10으로나누어 10보다 크면, addUp 1 로 저장하고 나머지 숫자를 result.next(다음자리)에 저장
            if (l1 is None):
                x = 0
            else:
                x = l1.val
            if (l2 is None):
                y = 0
            else:
                y = l2.val
            
            newNode = ListNode((x + y + addUp)%10) 
            result.next = newNode

            if x + y +addUp>= 10:
                addUp = 1 #올림을 위한 변수
            else:
                addUp = 0
            if l1 is not None:
                l1 = l1.next
            if l2 is not None:
                l2 = l2.next
            result = result.next
        
        #while문 끝났을때 addUp이 존재하면, result 에 한자리수가 더 추가되므로 이를 위한 조건
        if addUp == 1 :
            lastNode = ListNode(1)
            result.next = lastNode

        return head.next