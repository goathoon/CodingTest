from collections import deque
row, col = map(int, input().split())
last_row, last_col = row-1, col-1
map = []
visit = [[[0]*2 for _ in range(col)] for _ in range(row)]
# visit이 곧 여부이자 ,최단거리 저장하는 것
# 벽을 부수고난 후 의 경로와 벽을 부수기 전 경로를 visit에 한꺼번에 저장

for _ in range(row):
    map.append(input())

q = deque()
q.append((0, 0, 0))
visit[0][0][0] = 1
check = False
while q:
    now_row, now_col, isBreak = q.popleft()
    if now_row == last_row and now_col == last_col:
        check = True
        print(visit[now_row][now_col][isBreak])
        break
    dx = [1, 0, -1, 0]
    dy = [0, -1, 0, 1]
    for i in range(4):
        nx = dx[i] + now_col
        ny = dy[i] + now_row
        if nx <= -1 or nx >= col or ny <= -1 or ny >= row:
            continue
        if isBreak == 0:  # 벽을 부수지 않은 경우라면
            if map[ny][nx] == '1':
                if visit[ny][nx][1] != 0:
                    continue
                visit[ny][nx][1] = visit[now_row][now_col][isBreak] + 1
                q.append((ny, nx, 1))
            else:
                if visit[ny][nx][0] != 0:
                    continue
                visit[ny][nx][0] = visit[now_row][now_col][isBreak] + 1
                q.append((ny, nx, 0))
        else:
            if map[ny][nx] == '1':
                continue
            else:
                if visit[ny][nx][1] != 0:
                    continue
                visit[ny][nx][1] = visit[now_row][now_col][isBreak] + 1
                q.append((ny, nx, 1))
if not check:
    print(-1)
