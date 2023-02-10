N = int(input())

memo= [0]*1001
memo[1] = 1 #1
memo[2] = 2 #(1,1)(2)
memo[3] = 3 
memo[4] = 1+3+1  
for i in range(5,N+1):
    memo[i] = memo[i-1] + memo[i-2]

print(memo[N]%10007)