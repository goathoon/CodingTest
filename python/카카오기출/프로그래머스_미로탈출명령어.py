import sys
sys.setrecursionlimit(10 ** 6)
def dfs(x,y,r,c,dist,path):
    global answer
    # d l r u 로 최대한 깊게 들어가자
    dx = [0,-1,1,0]
    dy = [1,0,0,-1]
    if (dist - (abs(x-r) + abs(y-c))) % 2 != 0 or dist - (abs(x-r) + abs(y-c)) < 0:
        return False
    
    if dist == 0 and x == r and y == c:
        answer = path
        return True
    
    for i in range(4):
        if (x+dy[i] < 1 or x + dy[i] >= len(grid) or y + dx[i] < 1 or y + dx[i] >= len(grid[0])):
            continue
        else :
            if(dfs(x+dy[i],y+dx[i],r,c,dist-1,append_path(path,dy[i],dx[i]))):
                return True

            
  
def append_path(path_list,move_row,move_col):
    if move_row == 1:
        path_list += 'd'
    elif move_col == -1 :
        path_list += 'l'
    elif move_col == 1 :
        path_list += 'r'
    elif move_row == -1 :
        path_list += 'u'
    return path_list

def solution(n, m, x, y, r, c, k):
    global grid
    grid = [[0 for _ in range (m+1)] for _ in range(n+1)]
    grid[r][c] = 1
    global answer
    answer = ''
    if(dfs(x,y,r,c,k,answer)):
        return answer
    else:
        return "impossible"

