case = int(input())
order_list = []
answer = [1] * case
for _ in range(case):
    a,b = map(int,input().split())
    order_list.append((a,b))

for i in range(len(order_list)):
    key = order_list[i][0]
    muge = order_list[i][1]
    for j in range(len(order_list)):
        if key <order_list[j][0] and muge<order_list[j][1]:
            answer[i] += 1    
for i in range(len(answer)):
    print(answer[i])