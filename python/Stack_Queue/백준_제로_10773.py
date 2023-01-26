case = int(input())
stack = []
for _ in range(case):
    added = int(input())
    if added == 0:
        stack.pop()
    else :
        stack.append(added)
sum_all = 0
for i in stack:
    sum_all += i
print(sum_all)