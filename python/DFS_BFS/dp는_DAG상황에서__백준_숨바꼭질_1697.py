from collections import deque

start, end = map(int, input().split())

q = deque()
q.append((start, 0))
visited = [0] * 100002

while q:
    loc, depth = q.popleft()
    if loc == end:
        print(depth)
        break
    if loc - 1 >= 0:
        if visited[loc-1] != 1:
            q.append((loc-1, depth+1))
            visited[loc-1] = 1
    if 2*loc <= 100001:
        if visited[2*loc] != 1:
            q.append((2*loc, depth+1))
            visited[2*loc] = 1
    if loc + 1 <= 100001:
        if visited[loc+1] != 1:
            q.append((loc+1, depth+1))
            visited[loc+1] = 1
