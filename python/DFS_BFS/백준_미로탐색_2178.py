from collections import deque
row,col = map(int,input().split())
grid = []
visited = [[0]*col for _ in range(row)]

for _ in range(row):
    grid.append(list(map(int,input())))

q = deque()
q.append((1,0,0))
visited[0][0] = 1
answer = 1
dx = [1,0,-1,0]
dy = [0,-1,0,1]
while q :
    ans,pop_row,pop_col = q.popleft()
    if pop_row == row -1 and pop_col == col -1:
        print(ans)
        break
    for i in range(4):
        ny = pop_row + dy[i]
        nx = pop_col + dx[i]
        if  ny < 0 or ny >=row or nx<0 or nx>=col or visited[ny][nx] == 1 or grid[ny][nx] == 0:
            continue
        q.append((ans+1,ny,nx))
        visited[ny][nx] = 1
