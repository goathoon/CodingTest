#stack을 사용하게 되면 forward를 할 수 없습니다. (다 날아가 버리기 때문에)

class Node :
    def __init__(self, url):
        self.url = url
        self.next = None
        self.prev = None


class BrowserHistory(object): #자체로 Linked List

    def __init__(self, homepage):
        self.head = Node(homepage)
        self.curr = Node(homepage) # 현재노드 생성해주고, 해당 노드클래스로 방문기록을 추적
        # return None

    def visit(self, url): 
        self.curr.next = Node(url) # Linked List 연결 -
        # curr 뒤에 새로운 url을 가진 node를 추가하면서 해당 노드의 next 노드가 None이므로 forward 초기화

        self.curr.next.prev = self.curr # Linked List 연결

        self.curr = self.curr.next # curr 노드 이동
        return None

    def back(self, steps):
        while self.curr.prev is not None and steps != 0:
            self.curr = self.curr.prev
            steps -= 1
        return self.curr.url

    def forward(self, steps):
        while self.curr.next is not None and steps != 0:
            self.curr = self.curr.next
            steps -= 1
        return self.curr.url