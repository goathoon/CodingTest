case = int(input())
reg_list = []
for i in range(case):
    age,name = input().split()
    order = i
    age = int(age)
    reg_list.append((age,name,order))
reg_list.sort(key= lambda x : (x[0], x[2]))
for i in range(case):
    print(str(reg_list[i][0])+' '+reg_list[i][1])