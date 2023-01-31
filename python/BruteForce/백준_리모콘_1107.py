target = input()
num = int(input())
num_list = [i for i in range(10)]

if(num!=0):
    dif_list = list(map(int,input().split()))
    valid_list = list(set(num_list)-set(dif_list))
else :
    valid_list=num_list
answer = abs(int(target) - 100)
answer_num = 0
for i in range(1000001):
    i = str(i)
    for j in range(len(i)):
        if int(i[j]) not in valid_list:
            break
        elif j == len(i) - 1:
            answer = min(answer, len(i)+ abs(int(i) - int(target)))
print(answer)