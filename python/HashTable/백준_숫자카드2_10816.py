have = int(input())
num_dict = {}
num_list = list(map(int,input().split()))
for i in num_list:
    if i not in num_dict:
        num_dict[i] = 1
    else:
        num_dict[i] += 1
check = int(input())
check_list = list(map(int,input().split()))
answer = []
for j in check_list:
    if j not in num_dict:
        answer.append(0)
    else :
        answer.append(num_dict[j])
for i in range(check):
    print(answer[i],end=' ')