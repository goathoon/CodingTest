import sys
import heapq

n = int(sys.stdin.readline())
arr = []
for _ in range(n):
    x = int(sys.stdin.readline())
    if x == 0:
        if not arr:
            print(0)
            continue
        y = heapq.heappop(arr)
        print(y)
    else:
        heapq.heappush(arr, x)
