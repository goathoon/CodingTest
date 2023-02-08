import sys
import heapq

case = int(input())
for _ in range(case):
    max_hp = []
    min_hp = []
    isDel = [0] * 1000001
    op = int(input())
    for i in range(op):
        w,n = sys.stdin.readline().split()
        if w == 'I':
            heapq.heappush(max_hp,(-int(n),i))
            heapq.heappush(min_hp,(int(n),i))
        else :
            if n == '1':
                while max_hp and isDel[max_hp[0][1]] == 1: #지웠으면 pop해서 동기화함
                    heapq.heappop(max_hp)
                if max_hp:
                    isDel[max_hp[0][1]] = 1
                    heapq.heappop(max_hp)
            else :
                while min_hp and isDel[min_hp[0][1]] == 1:
                    heapq.heappop(min_hp)
                if min_hp:
                    isDel[min_hp[0][1]] = 1
                    heapq.heappop(min_hp)
        
        while max_hp and isDel[max_hp[0][1]] == 1:
            heapq.heappop(max_hp)
        while min_hp and isDel[min_hp[0][1]] == 1:
            heapq.heappop(min_hp)
    while max_hp and isDel[max_hp[0][1]] == 1:
        heapq.heappop(max_hp)
    while min_hp and isDel[min_hp[0][1]] == 1:
        heapq.heappop(min_hp)
    if max_hp and min_hp :
        print(-max_hp[0][0],min_hp[0][0])
    else:
        print("EMPTY")