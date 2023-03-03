from collections import deque


def solution(bridge_length, weight, truck_weights):
    answer = 1
    stack = [0] * bridge_length
    q = deque(stack)
    s = 0
    i = 0
    while True:  # 시간 흐름
        while i < len(truck_weights):
            s -= q.pop()
            if truck_weights[i] + s <= weight:
                q.appendleft(truck_weights[i])
                s += truck_weights[i]
                i += 1
            else:
                q.appendleft(0)
            answer += 1
        q.pop()
        answer += 1
        if not q:
            return answer - 1
