from itertools import combinations
n,m = map(int,input().split())
arr = [i for i in range(1,n+1)]
for result in combinations(arr,m):
    result_arr = list(result)
    result_arr.sort()
    for i in range(len(result_arr)):
        if i != len(result_arr) -1:
            print(result_arr[i],end=' ')
        else:
            print(result_arr[i])
            