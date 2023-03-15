comb_list = [[1]*101 for _ in range(101)]
comb_list[2][1] = 2
for i in range(3, 101):
    for j in range(1, i):
        comb_list[i][j] = comb_list[i-1][j-1]+comb_list[i-1][j]

n, m = map(int, input().split())
print(comb_list[n][m])
