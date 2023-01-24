n , k = map(int,input().split())

arr = [i for i in range(1, n+1)]
answer =[]

start = k-1
while arr :
    if start <= len(arr) - 1:
        now = arr[start]
        del arr[start]
    else :
        start = start % len(arr)
        now = arr[start]
        del arr[start]
    start += k -1
    answer.append(now)

print("<",end='')
for i in range(len(answer)):
    if i == len(answer)-1:
        print(answer[i],end='>')
    else:
        print(answer[i],end=', ')