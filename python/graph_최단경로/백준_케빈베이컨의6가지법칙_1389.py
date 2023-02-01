node,edge = map(int,input().split())
graph = [[987654321] * (node+1) for _ in range(node+1)]

for i in range(1,node+1):
    graph[i][i] = 0
            
for _ in range(edge):
    node1,node2 = map(int,input().split())
    graph[node1][node2] = 1
    graph[node2][node1] = 1

for i in range(1,node+1):
    for j in range(1,node+1):
        for k in range(1,node+1):
            graph[j][k] = min(graph[j][k],graph[j][i] + graph[k][i])

memo = [0] * (node+1)
val = 987654321
ans = 0
for i in range(1,len(graph)):
    memo[i] = sum(graph[i][1:])
    if memo[i] >= val:
        continue
    val = min(val,memo[i])
    ans = i
print(ans)