import sys
n = int(input())
grid = []

grid = list(map(int, sys.stdin.readline().split()))

min_grid = [[0] * 3 for _ in range(2)]
max_grid = [[0] * 3 for _ in range(2)]

min_grid[0][0], min_grid[0][1], min_grid[0][2] = grid[0], grid[1], grid[2]
max_grid[0][0], max_grid[0][1], max_grid[0][2] = grid[0], grid[1], grid[2]


for i in range(1, n):
    grid = list(map(int, sys.stdin.readline().split()))
    min_grid[1][0] = min(min_grid[0][0] + grid[0],
                         min_grid[0][1] + grid[0])
    min_grid[1][1] = min(min_grid[0][0] + grid[1], min_grid[0]
                         [1] + grid[1], min_grid[0][2] + grid[1])
    min_grid[1][2] = min(min_grid[0][1] + grid[2],
                         min_grid[0][2] + grid[2])

    max_grid[1][0] = max(max_grid[0][0] + grid[0],
                         max_grid[0][1] + grid[0])
    max_grid[1][1] = max(max_grid[0][0] + grid[1], max_grid[0]
                         [1] + grid[1], max_grid[0][2] + grid[1])
    max_grid[1][2] = max(max_grid[0][1] + grid[2],
                         max_grid[0][2] + grid[2])
    min_grid[0][0] = min_grid[1][0]
    min_grid[0][1] = min_grid[1][1]
    min_grid[0][2] = min_grid[1][2]
    max_grid[0][0] = max_grid[1][0]
    max_grid[0][1] = max_grid[1][1]
    max_grid[0][2] = max_grid[1][2]
print(max(max_grid[0]), min(min_grid[0]))
