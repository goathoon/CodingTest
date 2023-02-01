from collections import deque

node,edge = map(int,input().split())
graph = [[] for _ in range(node+1)] #리스트 컴프리헨션 ->리스트는 전역변수이므로 global 로 안써도됨.
memo = [0] * (node + 1)
visit = []
for _ in range(edge):
    node1,node2 = map(int,input().split())
    graph[node1].append(node2)
    graph[node2].append(node1)

def bfs(start,end):
    q = deque()
    q.append((start,0))
    visit.append(start)
    while q:
        node,depth = q.popleft()
        if(node == end):
            return depth
        for n in graph[node]:
            if n not in visit:
                q.append((n,depth+1))
                visit.append(n)

for i in range(1,node+1):
    for j in range(1,node+1):
        memo[i] += bfs(i,j)
        visit = []

val = 987654321
ans = 0
for i in range(1,node+1):
    if val == memo[i]:
        continue
    val = min(memo[i],val)
    if val == memo[i]:
        ans = i
print(ans)