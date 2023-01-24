N,M = map(int,input().split())

yaksu = 1
for i in range(2,min(N,M)+1):
    if N % i == 0 and M % i == 0:
        yaksu = i
print(yaksu)
print(int(yaksu * N / yaksu * M / yaksu))