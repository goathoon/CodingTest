import sys

num, case = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
for i in range(1, num):
    arr[i] += arr[i-1]

for _ in range(case):
    start, end = map(int, sys.stdin.readline().split())
    start = start - 2
    end = end-1
    if start < 0:
        print(arr[end])
        continue
    print(arr[end]-arr[start])
