N = int(input())
memo = [0] * 1001
memo[1] = 1
memo[2] = 3  # 1개로만드는법 1가지 2개로만드는법 2가지
memo[3] = 1 + 2*2  # 1개로만드는법 1가지 2개,1개로만드는법 2가지에 두가지 경우수
memo[4] = 1 + 3*2 + 2*2  # 11 memo[1] + (memo[2]-1)*3 + (memo[2]-1)*2

for i in range(5, 1001):
    memo[i] = memo[i-1] + memo[i-2] * 2

print(memo[N] % 10007)
