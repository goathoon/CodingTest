from collections import deque
N = int(input())

card_list = [ i for i in range(1,N+1)]
que = deque(card_list)

while que:
    first = que.popleft()        
    if not que:
        print(first)
        break
    second = que.popleft()
    if not que :
        print(second)
        break
    que.append(second)
    
        
    