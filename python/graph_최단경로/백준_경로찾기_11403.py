import sys

N = int(input())
graph = []

for _ in range(N):
    row_arr = list(map(int, sys.stdin.readline().strip().split()))
    for i in range(len(row_arr)):
        if row_arr[i] == 0:
            row_arr[i] = 987654321
    graph.append(row_arr)


for k in range(N):
    for i in range(N):
        for j in range(N):
            graph[i][j] = min(graph[i][k]+graph[k][j], graph[i][j])

for i in range(N):
    for j in range(N):
        if graph[i][j] != 987654321:
            if j == N-1:
                print(1)
                continue
            print(1, end=' ')
        else:
            if j == N-1:
                print(0)
                continue
            print(0, end=' ')
