case = int(input())
ans = [1, 1, 1, 2, 2]
for i in range(4, 101):
    ans.append(ans[i-4] + ans[i])
for _ in range(case):
    N = int(input())
    print(ans[N-1])
