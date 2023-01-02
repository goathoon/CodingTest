class Node : #linked list의 구현을 위해서 각각의 노드를 정의해야함. 숲을 만들기 위해 나무를 만드는 과정
    def __init__(self,data):
        self.data = data
        self.next = None

class LinkedList: 
    def __init__(self):
        self.nodeCount = 0 #생략 가능
        self.head = None
        self.tail = None

    def getNode(self, pos):
        if pos < 1 or pos > self.nodeCount:
            return False # 그럴일 없습니다.
        
        index = 1
        curr = self.head
        while pos != index:
            curr = curr.next
            index += 1
        return curr
    
    def append(self, pos, newNode ): 
        
        #말이 안되는 위치에 노드를 삽입하는 경우
        if pos <1 or pos > self.nodeCount:
            return False        
        
        #맨 앞에 삽입하는 경우 - 이경우는 head만 움직이면 된다. 단, 한개이상의 노드가 존재하는 연결리스트에 삽입하는 경우!
        if pos == 1:
            newNode.next = self.head #아무것도 존재하지 않은 연결리스트라고 해도 self.head= None으로 초기화 했기 때문에 문제없다.
            self.head = newNode
            #대신, 아무것도 존재하지 않았을때 tail을 맨 처음 노드로 지정해야한다. -- 맨 끝에 코드가 존재함.

        else:
            #맨 끝에 삽입하는 경우 넣을 곳은 tail의 next 위치임.
            if pos == self.nodeCount + 1: 
                prev = self.tail
            #중간에 삽입하는 경우 넣을 곳은 pos - 1 번째 노드의 next 위치임 - getNode 함수가 필요
            else:
                prev = self.getNode(pos-1)
        
            newNode.next = prev.next #뒤쪽부터 건들일것.
            prev.next = newNode
        
        if pos == self.nodeCount + 1: #마지막, newNode가 맨 끝에 삽입 된 경우 tail을 움직여야함 ! 
            self.tail = newNode
            
    def delete(self,pos):
        if pos < 1 or pos > self.nodeCount: 
            return False
        
        #맨 앞 노드를 끊어내는 경우
        if pos == 1: 
            curr = self.head
            #빈 리스트가 되는 경우 따로 빼서 처리
            if self.nodeCount == 1:
                self.head = None
                self.tail = None
            #그렇지 않다면 뒤쪽만 끊어낸다. head를 버리고 head.next를 head로 처리하면됨
            else:
                self.head = curr.next # self.head = self.head.next
        
        else:
            prev = self.getNode(pos - 1) # 없애려는 노드기준 앞노드를 찾습니다.
            curr = self.getNode(pos) # 없앨 노드
            if pos == self.nodeCount : #맨 끝 노드라면, 삭제하면서 tail이 수정되어야하므로 따로 뺌
                prev.next = None
                self.tail = prev
            else:
                prev.next = curr.next
        
        self.nodeCount -= 1