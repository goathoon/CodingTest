from collections import deque

N = int(input())
graph = []
visit = [[0]*N for _ in range(N)]
visit_n = [[0]*N for _ in range(N)]
for _ in range(N):
    graph.append(input())

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]


def bfs_n(row, col):
    q = deque()
    q.append((row, col, graph[row][col]))
    while q:
        now = q.popleft()
        now_row = now[0]
        now_col = now[1]
        now_val = now[2]

        for i in range(4):
            nx = now_col + dx[i]
            ny = now_row + dy[i]
            if 0 <= nx < N and 0 <= ny < N and visit[ny][nx] == 0:
                if graph[ny][nx] == now_val:
                    visit[ny][nx] = 1
                    q.append((ny, nx, now_val))
    return 1


def bfs_a(row, col):
    q = deque()
    q.append((row, col, graph[row][col]))
    while q:
        now = q.popleft()
        now_row = now[0]
        now_col = now[1]
        now_val = now[2]

        for i in range(4):
            nx = now_col + dx[i]
            ny = now_row + dy[i]
            if 0 <= nx < N and 0 <= ny < N and visit_n[ny][nx] == 0:
                if now_val == 'R' or now_val == 'G':
                    if graph[ny][nx] == 'G' or graph[ny][nx] == 'R':
                        visit_n[ny][nx] = 1
                        q.append((ny, nx, graph[ny][nx]))
                else:
                    if graph[ny][nx] == now_val:
                        visit_n[ny][nx] = 1
                        q.append((ny, nx, now_val))

    return 1


ans_n = 0
ans_a = 0
for r in range(N):
    for c in range(N):
        if visit[r][c] == 0:
            ans_n += bfs_n(r, c)
        if visit_n[r][c] == 0:
            ans_a += bfs_a(r, c)

print(ans_n, ans_a)
