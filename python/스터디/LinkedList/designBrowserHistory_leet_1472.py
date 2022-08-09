class Node:
    def __init__(self,data):
        self.data = data
        self.prev = None 
        self.next = None
        
class LinkedList:
    def __init__(self):
        self.nodeCount = 0
        self.head = None
        self.tail = None
    def append(self,newNode): # visit할 때가 append 하는것.
        if self.nodeCount == 0:
            self.head = newNode
            self.tail = self.head
        else:
            self.curr.next = newNode #현재 위치에서 갱신만 하면 됨
            newNode.prev = self.curr
            self.tail = newNode # 그리고 새로운 visit page의 다음노드는 None으로 초기화 = tail로 만들어주면 된다.
        self.nodeCount += 1
    
class BrowserHistory:

    def __init__(self, homepage: str):
        self.linkedList = LinkedList()
        firstNode = Node(homepage)
        self.linkedList.append(firstNode)
        self.linkedList.curr = firstNode
    def visit(self, url: str) -> None: #visit 하면 현재페이지 다음에 이어붙이되, forward page들은 초기화. (next = None)
        visitNode = Node(url)
        self.linkedList.append(visitNode)
        self.linkedList.curr = visitNode
    def back(self, steps: int) -> str:
        step = 0
        while self.linkedList.curr.prev != None and step < steps: #맨 앞페이지가 현재페이지던가, step이 steps이상이면 종료
            self.linkedList.curr = self.linkedList.curr.prev
            step += 1
        return self.linkedList.curr.data
    def forward(self, steps: int) -> str:
        step = 0
        while self.linkedList.curr.next != None and step < steps:
            self.linkedList.curr = self.linkedList.curr.next
            step += 1
        return self.linkedList.curr.data


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)