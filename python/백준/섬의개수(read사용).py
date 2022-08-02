import sys
read = sys.stdin.readline
sys.setrecursionlimit(10000)

def dfs (x,y,grid,visited):
    visited[y][x] = True #방문 처리하고
    dx = [1,1,1,0,-1,-1,-1,0]
    dy = [1,0,-1,-1,-1,0,1,1]
    for i in range(8):
        if x + dx[i] < 0 or x + dx[i] >= len(grid[0]) or y + dy[i] < 0 or y + dy[i] >= len(grid):
            continue
        else:
            if not visited[y+dy[i]][x+dx[i]] and grid[y+dy[i]][x+dx[i]] == 1 :
                dfs(x+dx[i],y+dy[i],grid,visited)
                
 
while True:
    count = 0
    w,h = map(int,read().split())
    if w == h == 0:
        break

    #지도 생성
    grid = []
    for _ in range(h):
        grid.append(list(map(int,read().split())))
    visited = [[False] * w for _ in range(h)]
    for row in range(len(grid)):
        for col in range(len(grid[0])):
            if not visited[row][col] and grid[row][col] == 1: #방문 안했고 , 육지라면,
                count +=1  
                dfs(col,row,grid,visited)
            else:
                visited[row][col] = True
    print(count)