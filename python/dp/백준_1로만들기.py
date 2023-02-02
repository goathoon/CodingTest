n = int(input())

memo = [987654321] * (n+1)
memo[1] = 0
for i in range(1,n+1):
    if i*3 <= n:
        memo[i*3] = min(memo[i]+1,memo[i*3])
    if i*2 <= n:
        memo[i*2] = min(memo[i]+1,memo[i*2])
    if i+1 <= n:
        memo[i+1] = min(memo[i]+1,memo[i+1])
print(memo[n])