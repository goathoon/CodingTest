import sys
# 시간복잡도 생각해보기, 각 노드에서 노드로가는 것을 각각 하는 것이기 때문에,
# 한 노드에서 다른 노드로 가는 노선을 찾는데는 100^2 번의 계산만 필요
N = int(input())
graph = []
visit = [0] * N
for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().strip().split())))


def dfs(x):
    for i in range(N):
        if graph[x][i] == 1 and visit[i] == 0:
            visit[i] = 1
            dfs(i)


for i in range(N):
    visit = [0]*N
    dfs(i)
    for j in range(N):
        if visit[j] == 1:
            if j == N-1:
                print(1)
                continue
            print(1, end=' ')
        else:
            if j == N-1:
                print(0)
                continue
            print(0, end=' ')
