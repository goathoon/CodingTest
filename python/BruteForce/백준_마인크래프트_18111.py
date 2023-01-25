import sys
input = sys.stdin.readline

sero,garo,block = map(int,input().split())
grid = []
answer = 987654321
max_high = 0
for _ in range(sero):
    added = list(map(int,input().split()))
    grid.append(added)

for high in range(257):
    catch_block = 0
    more_block = 0
    for row in range(len(grid)):
        for col in range(len(grid[0])):
            if grid[row][col] >high :
                catch_block += grid[row][col] - high
            else:
                more_block += high - grid[row][col]
    if more_block > block + catch_block :
        continue
    answer = min(answer,catch_block*2 + more_block)
    if answer == catch_block*2 + more_block:
        max_high = high
print(answer,max_high)


