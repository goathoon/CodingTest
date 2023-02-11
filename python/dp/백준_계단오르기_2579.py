N = int(input())
stair = [0] * (N+1)
for i in range(1,N+1):
    stair[i] = int(input().strip())
memo=[0]*(N+1)
memo[1] = stair[1]
if N >= 2:
    memo[2] = stair[2] + stair[1]

for i in range(3,N+1):
    memo[i] = memo[i-3]+ stair[i-1] + stair[i] #마지막 전 계단 밟음
    memo[i] = max(memo[i],memo[i-2]+stair[i]) #마지막 전전계단을 밟음

print(memo[N])
