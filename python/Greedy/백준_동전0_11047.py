N,amount = map(int,input().split())

arr = []
for _ in range(N):
    arr.append(int(input()))

ans = 0
for i in range(N-1,-1,-1):
    while arr[i] <= amount:
        amount -= arr[i]
        ans +=1
    

if amount == 0:
    print(ans)
