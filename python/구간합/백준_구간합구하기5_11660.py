import sys
input = sys.stdin.readline

N, M = map(int, input().split())
grid = [[0] * (N+1)]
sum_grid = [[0]*(N+1) for _ in range(N+1)]
for i in range(N):
    grid.append([0] + list(map(int, input().split())))  # 0으로 추가하기.
    # 그래야 쉽게 result부분에서 생길 index out of range를 해결할 수 있다. + 계산에 영향을 주지 않기위해
    # 0으로 초기화
for i in range(1, N+1):
    for j in range(1, N+1):
        sum_grid[i][j] = sum_grid[i-1][j] + \
            sum_grid[i][j-1] - sum_grid[i-1][j-1] + grid[i][j]
for i in range(M):
    s_r, s_c, d_r, d_c = map(int, input().split())
    ans = sum_grid[d_r][d_c] - sum_grid[s_r-1][d_c] - \
        sum_grid[d_r][s_c-1] + sum_grid[s_r-1][s_c-1]
    print(ans)
