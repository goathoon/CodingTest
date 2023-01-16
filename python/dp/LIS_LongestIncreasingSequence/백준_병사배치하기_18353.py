num = int(input())
memo = [1] * num
soldier = list(map(int,input().split()))
for i in range(1,num):
    for j in range(0,i):
        if soldier[j] > soldier[i] :
            memo[i] = max(memo[i], memo[j]+ 1)
print(num - max(memo))
            