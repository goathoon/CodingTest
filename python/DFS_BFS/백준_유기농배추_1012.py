from collections import deque

import sys
input = sys.stdin.readline

case = int(input())
for _ in range(case):
    garo,sero,num = map(int,input().split())
    grid = [[0]*garo for _ in range(sero)]
    for _ in range(num):
        col,row = map(int,input().split())
        grid[row][col] = 1
    dx = [1,0,-1,0]
    dy = [0,-1,0,1]
    q = deque()
    answer = 0
    for row in range(sero):
        for col in range(garo):
            if grid[row][col] == 1:
                q.append((row,col))
                grid[row][col] = 0
                while q :
                    popele = q.popleft()
                    for i in range(4):
                        if popele[0] + dy[i] < 0 or popele[0] + dy[i] >= len(grid) or popele[1] + dx[i] < 0 or popele[1] + dx[i] >=len(grid[0])or grid[popele[0]+dy[i]][popele[1]+dx[i]] == 0:
                            continue
                        else:
                            q.append((popele[0]+dy[i],popele[1]+dx[i]))
                            grid[popele[0]+dy[i]][popele[1]+dx[i]] = 0
                answer += 1
    print(answer)
