import sys
sys.setrecursionlimit(10**7)
n = int(input())
node_dict = {i: [] for i in range(n+1)}
visit = [0] * (n+1)
ans = [0]*(n+1)
# dictionary 초기화
for _ in range(n-1):
    a, b = map(int, input().split())
    node_dict[a].append(b)
    node_dict[b].append(a)


def dfs(node):
    visit[node] = 1
    for n in node_dict[node]:
        if visit[n] == 0:
            ans[n] = node
            dfs(n)


dfs(1)
for i in range(2, n+1):
    print(ans[i])
