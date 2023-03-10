import sys
import heapq
v = int(input())
e = int(input())

graph = [[] for _ in range(v+1)]
dist = [1e9] * (v+1)
for _ in range(e):
    start, end, cost = map(int, sys.stdin.readline().split())
    graph[start].append((end, cost))
start_node, end_node = map(int, sys.stdin.readline().split())
dist[start_node] = 0
q = []
heapq.heappush(q, (0, start_node))
while q:
    cur_cost, cur_node = heapq.heappop(q)
    if dist[cur_node] < cur_cost:  # 방문한 셈
        continue
    for edge in graph[cur_node]:
        next_node, add_cost = edge
        if dist[next_node] > dist[cur_node] + add_cost:
            dist[next_node] = dist[cur_node] + add_cost
            heapq.heappush(q, (dist[cur_node]+add_cost, next_node))
print(dist[end_node])
