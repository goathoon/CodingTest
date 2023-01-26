from collections import deque
case = int(input())
for _ in range(case):
    many,check = map(int,(input().split()))
    prior_list = list(map(int,input().split()))
    que = deque()
    for index,prior in enumerate(prior_list):
        que.append((index,prior))    
    cnt = 0
    while que:
        que_len = len(que)
        pop_idx, pop_ele = que.popleft()
        for i in range(len(que)):
            if que[i][1] > pop_ele :
                que.append((pop_idx,pop_ele))
                break
        
        if que_len != len(que):
            if pop_idx == check:
                print(cnt+1)
            else :
                cnt += 1           
            
            
    
        
    
    
    