from collections import deque
def solution(queue1, queue2):
    sum_result = sum_elements(queue1,queue2)
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    if (sum_result % 2 !=0) :
        return -1
    else:
        target = sum_result / 2
    
    answer = 0
    sum_q1 = sum(queue1)
    while(sum_q1 != target and len(queue1) >0 and len(queue2) > 0):
        if (sum_q1 > target):
            pop_ele = queue1.popleft()
            sum_q1 -= pop_ele
        else:
            add_ele = queue2.popleft()
            queue1.append(add_ele)
            sum_q1 += add_ele
            
        answer += 1
    if (sum_q1 == target):
        return answer
    else:
        return -1
        

def sum_elements(queue1,queue2):
    return sum(queue1) + sum(queue2)
