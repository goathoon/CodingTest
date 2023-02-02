N = int(input())
num = 1
for i in range(2, N+1):
    num *= i

num = str(num)
for i in range(len(num)-1, -1, -1):  # for 문 역순으로 돌릴때 마지막 종료조건 -1로해야 0까지 포함됨
    if num[i] == '0':
        continue
    else:
        print(len(num)-i-1)
        break
