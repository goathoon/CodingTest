import sys
import heapq
node,edge = map(int,input().split())
graph = [[] for _ in range(node+1)]
for _ in range(edge):
    n1,n2,cost = map(int,sys.stdin.readline().split())
    graph[n1].append((n2,cost))
    graph[n2].append((n1,cost))

via1,via2 = map(int,input().split())


visit = [1e9] * (node+1)

def dijkstra(start_node,last_node):
    visit = [987654321] * (node+1)
    visit[start_node] = 0
    q = []
    heapq.heappush(q,(0,start_node))
    while q :
        now_val,now_node = heapq.heappop(q)
        if now_node == last_node:
            return now_val
        if visit[now_node] < now_val:
            continue
        for tup in graph[now_node]:
            n,v = tup
            c = v +now_val
            if c < visit[n]:
                visit[n] = c
                heapq.heappush(q,(c,n))
    return 1e9

val1 = dijkstra(1,via1)
val2 = dijkstra(1,via2)
val3 = dijkstra(via1,via2)
val4 = dijkstra(via1,node)
val5 = dijkstra(via2,node) 

via_val = val1 + val3 + val5
via_val2 = val2 + val3 + val4

ans = min(via_val,via_val2)

if ans >= 1e9:
    #망할 1e9 와 똑같을때가있었다니.. 좀더 strict하게 풀것.
    print(-1)
else:
    print(ans)

        