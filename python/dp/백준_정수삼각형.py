N = int(input())
graph = []
for i in range(N):
    graph.append(list(map(int, input().split())))

for i in range(1, N):
    for j in range(0, i+1):
        if j == 0:
            graph[i][j] += graph[i-1][j]
        elif j == i:
            graph[i][j] += graph[i-1][j-1]
        else:
            graph[i][j] += max(graph[i-1][j-1], graph[i-1][j])

print(max(graph[N-1]))
