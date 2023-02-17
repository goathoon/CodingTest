N = int(input())
import sys
sys.setrecursionlimit(10**9)
graph =[[] for _ in range(N+1)]
visit = [0] * (N+1)
for _ in range(N):
    add_arr =list(map(int,input().split()))
    graph[add_arr[0]] = add_arr[:-1]

def dfs(val,node):
    visit[node] = 1
    return_val = 0
    return_tup = (val,node)
    for idx in range(1,len(graph[node]),2):
        if visit[graph[node][idx]] == 0:
            dfs_tup = dfs(val+graph[node][idx+1],graph[node][idx])
            return_val = max(dfs_tup[0],return_tup[0])
            if return_val == dfs_tup[0]:
                return_tup = dfs_tup
    return return_tup
                
start_node = dfs(0,1)[1]
visit = [0] * (N+1)
print(dfs(0,start_node)[0])
                
            