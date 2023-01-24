import sys
input = sys.stdin.readline
from collections import deque
case = int(input())
q = deque()

for _ in range(case):
    command = input().split()
    if command[0] == "push_back":
        q.append(command[1])
    elif command[0] == "push_front":
        q.appendleft(command[1])
    elif command[0] == "front":
        if not q:
            print("-1")
        else :
            print(q[0])
    elif command[0] == "back":
        if not q:
            print("-1")
        else :
            print(q[-1])
    elif command[0] == "size":
        print(len(q))
    elif command[0] == "pop_front":
        if not q :
            print("-1")
        else :
            print(q.popleft())
    elif command[0] == "pop_back":
        if not q :
            print("-1")
        else :
            print(q.pop())
    elif command[0] == "empty":
        if not q :
            print("1")
        else:
            print("0")