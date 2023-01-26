import sys
input = sys.stdin.readline
N = int(input())
req_list = list(map(int,input().rstrip().split()))
money = int(input())

req_list.sort()
maxReq = req_list[-1]
minReq = 1
upperMoney = 0
while minReq <= maxReq:
    mid = (minReq + maxReq) // 2
    nowMoney = 0
    for i in range(N):
        if req_list[i] >= mid :
            nowMoney += mid
            continue
        else:
            nowMoney += req_list[i]
    if nowMoney < money:
        upperMoney = mid
        minReq = mid + 1
    elif nowMoney > money:
        maxReq = mid - 1
    else :
        upperMoney = mid
        print(upperMoney)
        exit()
print(upperMoney)



