import sys
input = sys.stdin.readline
case = int(input())
num_list = []
for _ in range(case):
    num_list.append(int(input()))

num_list.sort()
sum_all = 0
num_dict = {}
cnt_list = []
for i in range(len(num_list)):
    sum_all += num_list[i]
    
i = 0    
while True:
    cnt = 1
    while i+1 < len(num_list) and num_list[i] == num_list[i+1] :
        cnt += 1
        i+=1
    cnt_list.append((num_list[i],cnt))
    if i == len(num_list) - 1:
        break
    i += 1


print(round(sum_all / len(num_list)))
print(num_list[len(num_list)//2])
cnt_list.sort(key= lambda x : (-x[1],x[0]))

if len(cnt_list) >= 2 and cnt_list[0][1] == cnt_list[1][1] :
    print(cnt_list[1][0])
else :
    print(cnt_list[0][0])
print(num_list[-1] - num_list[0])