N, num = map(int, input().split())
grid = []
sum_grid = [[0]*N for _ in range(N)]
for _ in range(N):
    grid.append(list(map(int, input().split())))
sum_grid[0][0] = grid[0][0]

for row in range(N):
    for col in range(N):
        if row > 0:
            if col > 0:
                sum_grid[row][col] = sum_grid[row-1][col] + \
                    sum_grid[row][col-1] + grid[row][col]
            else:
                sum_grid[row][col] = sum_grid[row-1][col] + grid[row][col]
        else:
            if col == 0:
                continue
            else:
                sum_grid[row][col] = sum_grid[row][col-1] + grid[row][col]
for _ in range(num):
    s_r, s_c, d_r, d_c = map(int, input().split())

print(sum_grid)
