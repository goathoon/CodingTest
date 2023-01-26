Y,X = map(int,input().split())
grid = []
for i in range(Y):
    grid.append(input())
result = []
for y in range(Y-7): #y시작점
    for x in range(X-7):#x시작점
        cnt_W = 0
        cnt_B = 0
        for chess_y in range(y, y+8):
            for chess_x in range(x, x+8):
                if (chess_y + chess_x) % 2 == 0:
                    if grid[chess_y][chess_x] != 'B':
                        cnt_W += 1
                    if grid[chess_y][chess_x] != 'W':
                        cnt_B += 1
                else:
                    if grid[chess_y][chess_x] != 'W':
                        cnt_W += 1
                    if grid[chess_y][chess_x] != 'B':
                        cnt_B += 1
        result.append(cnt_W)
        result.append(cnt_B)
print(min(result))
