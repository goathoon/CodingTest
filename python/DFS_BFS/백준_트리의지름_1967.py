import sys
sys.setrecursionlimit(10**9)
N = int(input())
graph = [[] for _ in range(N+1)]
for _ in range(N-1):
    added_arr = list(map(int,input().strip().split()))
    graph[added_arr[0]].append((added_arr[1],added_arr[2]))
    graph[added_arr[1]].append((added_arr[0],added_arr[2]))
visit = [0] * (N+1)
def dfs(val,node):
    visit[node] = 1
    return_val = 0
    return_tup = (val,node)
    for idx in range(len(graph[node])):
        if visit[graph[node][idx][0]] == 0:
            dfs_val = dfs(val+graph[node][idx][1],graph[node][idx][0])
            return_val = max(dfs_val[0],return_tup[0])
            if return_val == dfs_val[0]:
                return_tup = dfs_val
    return return_tup

start_node=dfs(0,1)[1]
visit = [0] * (N+1)
print(dfs(0,start_node)[0])