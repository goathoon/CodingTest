import sys
sys.setrecursionlimit(10**7)
node,edge = map(int,input().split())
visit=[0] * (node+1)
graph = [[] for _ in range(node+1)]
for _ in range(edge):
    node1,node2 = map(int,sys.stdin.readline().strip().split())
    graph[node1].append(node2)
    graph[node2].append(node1)
    
def dfs(node): #dfs 종료시 횟수 반환 dfs visit유의
    visit[node] = 1
    for n in graph[node]:   
        if visit[n] == 0:
            dfs(n)

answer = 0
for i in range(1,node+1):
    if visit[i] == 0:
        dfs(i)
        answer+=1
print(answer)
