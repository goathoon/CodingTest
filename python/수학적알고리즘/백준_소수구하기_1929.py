N,M = map(int,input().split())

sosu_map = [True] * (M+1)
sosu_map[1] = False
last = int(M**(1/2))
for i in range(2,last+1):
    if sosu_map[i] == True:
        for j in range(2, M//i + 1):
            sosu_map[i*j] = False
for i in range(N,len(sosu_map)):
    if sosu_map[i] == True:
        print(i)
    