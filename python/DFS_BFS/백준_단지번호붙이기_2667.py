N = int(input())
graph = []
visit = [[0]*N for _ in range(N)]
for _ in range(N):
    graph.append(input())

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]
num = 0
ans = []


def dfs(row, col):
    visit[row][col] = 1
    global num
    num += 1
    for i in range(4):
        nx = col + dx[i]
        ny = row + dy[i]
        if 0 <= nx <= N-1 and 0 <= ny <= N-1 and visit[ny][nx] == 0:
            if graph[ny][nx] == '1':
                dfs(ny, nx)


for r in range(N):
    for c in range(N):
        if visit[r][c] == 0 and graph[r][c] == '1':
            dfs(r, c)
            ans.append(num)
            num = 0

print(len(ans))
ans.sort()
for val in ans:
    print(val)
