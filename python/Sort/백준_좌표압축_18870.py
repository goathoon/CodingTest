N= int(input())
ans_arr=[0]*N
arr = list(map(int,input().split()))

for i in range(N):
    arr[i] = (arr[i],i)

arr.sort(key=lambda x : x[0])
idx = 0
val = 0
while idx < N:
    ans_arr[arr[idx][1]] = val

    while idx+1<N and arr[idx][0] == arr[idx+1][0] :
        idx += 1
        ans_arr[arr[idx][1]] = val
    idx += 1
    val+=1

for i in range(len(ans_arr)):
    print(ans_arr[i],end=' ')