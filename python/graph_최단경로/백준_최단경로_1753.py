import sys
import heapq
node,edge =map(int,input().split())
start_node = int(input())

graph = [[] for _ in range(node+1)]
visit = [987654321] * (node+1)
for _ in range(edge):
    list_arr = list(map(int,sys.stdin.readline().split()))
    graph[list_arr[0]].append((list_arr[1],list_arr[2]))
    
visit[start_node] = 0
q = []
heapq.heappush(q,(0,start_node))
while q:
    now_val, now_node = heapq.heappop(q)
    if visit[now_node] < now_val:
        continue
    for i in graph[now_node] :
        next_node,next_val = i
        cost = now_val + next_val
        if cost < visit[next_node] :
            visit[next_node] = cost
            heapq.heappush(q,(cost,next_node))

for i in range(1,node+1):
    if i == start_node:
        print(0)
        continue
    if visit[i] != 987654321:
        print(visit[i])
    else:
        print("INF")
        
