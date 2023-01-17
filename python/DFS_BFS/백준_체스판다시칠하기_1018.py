"""
dfs와 완전 유사함
감을 잡고서 왜 ..?
그렇다면 왜 visit을 체크하지 않아서 오래걸렸을까 반성할 것
"""

import sys
input = sys.stdin.readline
Y,X = map(int,input().split())
grid = []
visit_grid = [[0]*X for _ in range(Y)]
def listCount(list,x,first_col,second_col):
    cnt = 0
    for i in range(x,x+8):
        if i%2 == 0 :
            if list[0][i] != first_col :
                cnt += 1
        else :
            if list[0][i] != second_col:
                cnt += 1
    return cnt
      
for _ in range(Y):
    line = input().rstrip().split()
    grid.append(line)
row = 0 
col = 0
global cnt 
cnt = 987654321

def visitGrid(grid,x,y):
    cnt_W = 0
    cnt_B = 0
    if visit_grid[y][x] == 1:
        return -1
    if x+7 > X-1 or y+7 >Y-1:
        return -1
    for i in range(y,y+8):
        if i % 2 == 0:
            cnt_W += listCount(grid[i],x,'W','B')
        else :
            cnt_W += listCount(grid[i],x,'B','W')
        if i % 2 == 0:
            cnt_B += listCount(grid[i],x,'B','W')
        else :
            cnt_B += listCount(grid[i],x,'W','B')
    global cnt
    visit_grid[y][x] = 1
    visitGrid(grid,x+1,y)
    visitGrid(grid,x,y+1)
    cnt = min(cnt,cnt_W,cnt_B)
    return 0
visitGrid(grid,0,0)
print(cnt)
