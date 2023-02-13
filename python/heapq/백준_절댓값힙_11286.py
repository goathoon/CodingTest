import heapq
import sys

N =int(input())
arr = []
for _ in range(N):
    push = int(sys.stdin.readline())
    if push != 0:
        if push < 0:
            heapq.heappush(arr,(-push,push)) 
        else:
            heapq.heappush(arr,(push,push))
    else:
        if not arr :
            print(0)
        else:
            print(heapq.heappop(arr)[1])
    