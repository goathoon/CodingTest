import sys
import heapq
node, edge, x = map(int,input().split())
graph = [[] for _ in range(node+1)]
reverse_graph = [[] for _ in range(node+1)]
visit = [987654321]* (node+1)
reverse_visit = [987654321]* (node+1)
for _ in range(edge):
    n1,n2,cost = map(int,sys.stdin.readline().split())
    graph[n1].append((n2,cost))
    reverse_graph[n2].append((n1,cost))

q = []
heapq.heappush(q,(0,x))
visit[x] = 0
while q:
    val,pop_node = heapq.heappop(q)
    if visit[pop_node] < val:
        continue
    for i in graph[pop_node]:
        edge_val = i[1] + val
        if edge_val < visit[i[0]]:
            visit[i[0]] = edge_val
            heapq.heappush(q,(edge_val,i[0]))
q = []
heapq.heappush(q,(0,x))
reverse_visit[x] = 0
while q:
    val,pop_node = heapq.heappop(q)
    if reverse_visit[pop_node] < val:
        continue
    for i in reverse_graph[pop_node]:
        edge_val = i[1] + val
        if edge_val < reverse_visit[i[0]]:
            reverse_visit[i[0]] = edge_val
            heapq.heappush(q,(edge_val,i[0]))

return_max = 0
for i in range(1,node+1):
    return_max = max(visit[i]+reverse_visit[i],return_max)
print(return_max)