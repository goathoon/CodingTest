import sys
case = int(input())
for _ in range(case):   
    ans = 0
    N,M,x,y = map(int,sys.stdin.readline().strip().split())
    
    yaksu = 1
    for i in range(2,min(N,M)+1):
        if N % i == 0 and M % i == 0:
            yaksu = i
    last = int(N * M / yaksu)
    flag = False
    plus = max(N,M)
    if plus == N:
        start = x
    else :
        start = y
    while start <= last:
        if (start - x) % N == 0 and (start - y) % M == 0:
            flag = True
            break
        start += plus
    if flag :
        print(start)
    else:
        print(-1)