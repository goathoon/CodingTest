fibo = [[0,0] for _ in range(41)]
answer = [0,0]

case = int(input())

fibo[0] = [1,0]
fibo[1] = [0,1]
fibo[2] = [1,1]
for i in range(3,41):
    fibo[i] = [fibo[i-1][0] + fibo[i-2][0],fibo[i-1][1]+fibo[i-2][1]] 

for _ in range(case):
    answer = [0,0]
    n = int(input())
    print(fibo[n][0],fibo[n][1])