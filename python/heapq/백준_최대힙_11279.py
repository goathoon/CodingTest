import heapq
import sys

n = int(input())
arr = []
for _ in range(n):
    x = int(input())
    if x != 0:
        heapq.heappush(arr,-x)
    else :
        if arr :
            ans = heapq.heappop(arr)
            print(-ans)
        else:
            print(0)
