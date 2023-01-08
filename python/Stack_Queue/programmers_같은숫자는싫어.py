from collections import deque

def solution(arr):
    answer = []
    que = deque(arr)
    while que :
        num = que.popleft()
        if answer and answer[-1] != num:
            answer.append(num)
        if not answer :
            answer.append(num)
    
    return answer