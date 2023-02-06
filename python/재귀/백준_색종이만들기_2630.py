import sys
N = int(input())
grid = []
for _ in range(N):
    grid.append(list(map(int,input().split())))
    

white = 0
blue = 0

def paper(row,col,N):
    num = grid[row][col]
    global white
    global blue
    for garo in range(row,row+N):
        for sero in range(col,col+N):
            if grid[garo][sero] != num:
                paper(row,col,N//2)
                paper(row,col+N//2,N//2)
                paper(row+N//2,col,N//2)
                paper(row+N//2,col+N//2,N//2)
                return
    if num == 1:
        blue +=1
    else :
        white+=1
    return       
paper(0,0,8)
print(white)
print(blue)