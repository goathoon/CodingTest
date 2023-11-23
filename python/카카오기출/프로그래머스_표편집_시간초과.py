class Node:
    def __init__(self,is_delete):
        self.next = None
        self.prev = None
        self.delete = is_delete
class LinkedList:
    def __init__(self):
        self.head = None
        self.count = 0
        
    def getNode(self,pos):
        idx = 1
        curr = self.head
        while idx < pos:
            curr = curr.next
            idx += 1
        return curr
    def moveNode(self,cur_node,is_up,cnt):
        cnt = int(cnt)
        while cnt > 0:
            if is_up :  
                cur_node = cur_node.prev
                cnt -= 1
            else:
                cur_node = cur_node.next
                cnt -= 1
        return cur_node
    def append(self,pos,newNode):
        if pos == 1:
            newNode.next = self.head
            self.head = newNode
            
        else:
            if pos == self.count +1 :
                tailNode = self.getNode(self.count)
                newNode.prev = tailNode
                tailNode.next = newNode
            else:
                prevNode = self.getNode(pos-1)
                nextNode = prevNode.next
                newNode.next = nextNode
                newNode.prev = prevNode
                prevNode.next = newNode
                nextNode.prev = newNode
                
        self.count += 1
    def delete(self,pos):
        if pos == 1: 
            curr = self.head
            if self.count == 1:
                self.head = None
                self.tail = None
            else:
                self.head = curr.next # self.head = self.head.next
            self.count -= 1
            return self.head
        
        else:
            prev = self.getNode(pos - 1) # 없애려는 노드기준 앞노드를 찾습니다.
            curr = self.getNode(pos) # 없앨 노드
            if pos == self.count : 
                prev.next = None
                self.count -= 1
                return prev
            else:
                prev.next = curr.next
                curr.next.prev = prev
                self.count -= 1
                return curr.next
            

        
def solution(n, k, cmd):
    linked_list = LinkedList()
    for i in range(1,n+1):
        node = Node(False)
        linked_list.append(i,node)

    pointer = k+1
    curr = linked_list.getNode(pointer)    
    erase_stack = []
    for c in cmd:
        parsed = c.split(' ')
        if parsed[0] == 'D':
            cnt = int(parsed[1])
            curr = linked_list.moveNode(curr,False,cnt)
            pointer += cnt
        elif parsed[0] == 'C':
            curr = linked_list.delete(pointer)
            erase_stack.append(pointer)
            if pointer == linked_list.count+1 : # 맨 마지막을 삭제했을경우 pointer는 하나 줄어야한다.
                pointer -= 1
                
            
        elif parsed[0] == 'U':
            cnt = int(parsed[1])
            curr = linked_list.moveNode(curr,True,cnt)
            pointer -= cnt
        elif parsed[0] == 'Z':
            last_pointer = erase_stack.pop()
            node = Node(False)
            if pointer >= last_pointer:
                pointer += 1
            linked_list.append(last_pointer,node)
            

    while erase_stack:
        erased_pointer = erase_stack.pop()
        node = Node(True)
        linked_list.append(erased_pointer,node)
    answer = ''
    curr = linked_list.head
    while curr != None:
        if curr.delete :
            answer+='X'
        else:
            answer+='O'
        curr = curr.next
    return answer

        
    