from collections import deque

node,edge,start = map(int,input().split())

graph = [[] for _ in range(node+1)]
visit = []
for _ in range(edge):
    node1,node2 = map(int,input().split())
    graph[node1].append(node2)
    graph[node2].append(node1)

for i in range(1,node+1):
    graph[i].sort()
    
dfs_list = []
#dfs
def dfs(cur_node):
    global visit
    global dfs_list
    dfs_list.append(cur_node)
    visit.append(cur_node)
    for node in graph[cur_node]:
        if node not in visit:
            dfs(node)

bfs_list = []
#bfs

def bfs(cur_node):
    global visit
    global bfs_list
    visit.append(cur_node)
    bfs_list.append(cur_node)
    q = deque()
    q.append(cur_node)
    while q:
        now = q.popleft()
        for node in graph[now]:
            if node not in visit:
                q.append(node)
                visit.append(node)
                bfs_list.append(node)   

dfs(start)
for i in range(len(dfs_list)):
    print(dfs_list[i],end=' ')
print()
visit = []
bfs(start)
for i in range(len(bfs_list)):
    print(bfs_list[i],end=' ')