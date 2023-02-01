from collections import deque
N = int(input())

memo = set()
q = deque()
q.append((N,0))
memo.add(N)
while q :
    x,cnt = q.popleft()
    if x == 1:
        print(cnt)
        break
    if x%3 == 0 :
        if x/3 not in memo:
            q.append((x/3,cnt+1))
            memo.add(x/3)
    if x%2 == 0:
        if x/2 not in memo:
            q.append((x/2,cnt+1))
            memo.add(x/2)
    if x-1 not in memo:
        q.append((x-1,cnt+1))
        memo.add(x-1)