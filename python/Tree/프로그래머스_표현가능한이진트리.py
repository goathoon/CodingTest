from collections import deque
import math

def decimal_to_binary(number):
    queue = deque()
    while True:
        if number // 2 == 0:
            queue.appendleft(number%2)
            return list(queue)
        queue.appendleft(number%2)
        number //= 2

def solution(numbers):
    answer = [0] * len(numbers)
    for idx, number in enumerate(numbers):
        binary_list = decimal_to_binary(number)
        answer[idx] = 1 if(is_possible(binary_list)) else 0
        
    return answer

def is_possible(binary_list):
    if len(binary_list) == 1:
        return True
    # 노드 개수 구하기 -> 포화이진트리의 노드 총 개수
    node_num = 2 ** (int(math.log(len(binary_list),2)) + 1) - 1
    # binary_list에 node_num만큼의 0을 추가하여 포화이진트리를 만들수있나?
    # 이미 도달해야하는 정확한 이진수의 값은 구해졌고, 이를 딱 맞추기 위해서는 앞에 0을 더 추가해야함
    queue = deque(binary_list)
    for i in range(node_num - len(binary_list)):
        queue.appendleft(0)
    
    binary_list = list(queue)
    
    if binary_list[node_num//2] == 0:
        if len(set(binary_list)) == 2:
            return False
        else:
            return True

    
    return is_possible(binary_list[:node_num//2]) and is_possible(binary_list[node_num//2+1:])