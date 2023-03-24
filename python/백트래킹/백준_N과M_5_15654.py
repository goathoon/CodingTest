n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
ans = []


def dfs(x):
    if x == m+1:
        print(' '.join(map(str, ans)))
        return
    for val in arr:
        if val not in ans:

            ans.append(val)
            dfs(x+1)
            ans.pop()


dfs(1)
