import heapq

s,e = map(int,input().split())

q = []
visit = [0]* 200001
q.append((0,s))
visit[s] = 1
while q:
    time,loc = heapq.heappop(q)
    if loc == e:
        print(time)
        break
    if 2*loc <200001 and not visit[2*loc]:
        heapq.heappush(q,(time,2*loc))
        visit[2*loc] = 1
    if loc+1 <200001 and not visit[loc+1]:
        heapq.heappush(q,(time+1,loc+1))
        visit[loc+1] = 1
    if loc-1 >=0 and not visit[loc-1]:
        heapq.heappush(q,(time+1,loc-1))
        visit[loc-1] = 1

