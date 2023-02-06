N = int(input())
memo = [0] * 12

memo[1] = 1
memo[2] = 2 # memo[1]+memo[1] + 1
memo[3] = 4 # 
memo[4] = 7 # 
memo[5] = 14 # 
memo[6] = 28
memo[7] = 56 #1,1,1,1, 
# 1, 1,2
for i in range(4,11):
    memo[i] = memo[i-1] + memo[i-2] + memo[i-3]

for _ in range(N):
    print(memo[int(input())])