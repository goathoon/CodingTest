case = int(input())
check_list = list(map(int,input().split()))
answer = len(check_list)
if 1 in check_list :
    answer -= 1
for check in check_list:
    for mod in range(2,int(check**(1/2))+1):
        if check % mod == 0 :
            answer-=1
            break
print(answer)