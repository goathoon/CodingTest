import sys

v, e = map(int, input().split())
edge_list = []

dist = [987654321] * (v+1)
for _ in range(e):
    start, end, cost = map(int, sys.stdin.readline().split())
    edge_list.append((start, end, cost))

dist[1] = 0
check = False
for i in range(v):
    for edge in edge_list:
        cur_node, next_node, cost = edge
        if dist[cur_node] != 987654321 and dist[next_node] > dist[cur_node] + cost:
            dist[next_node] = dist[cur_node] + cost
            if i == v-1:
                check = True

if check:
    print(-1)
else:
    for i in range(2, v+1):
        if dist[i] == 987654321:
            print("-1")
        else:
            print(dist[i])
