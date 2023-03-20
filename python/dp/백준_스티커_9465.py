case = int(input())
for _ in range(case):
    n = int(input())
    grid = []
    for _ in range(2):
        grid.append(list(map(int, input().split())))

    memo = [[0]*n for _ in range(2)]
    memo[0][0] = grid[0][0]
    memo[1][0] = grid[1][0]
    if n >= 2:
        memo[0][1] = memo[1][0] + grid[0][1]
        memo[1][1] = memo[0][0] + grid[1][1]
    if n > 2:
        for col in range(2, n):
            memo[0][col] = max(memo[1][col-1], memo[1][col-2]) + grid[0][col]
            memo[1][col] = max(memo[0][col-1], memo[0][col-2]) + grid[1][col]
    print(max(memo[0][n-1], memo[1][n-1]))
