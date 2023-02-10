import sys

node,edge = map(int,input().split())
parent=[i for i in range(node+1)]

def find_parent(x):
    if parent[x] != x:
        parent[x] = find_parent(parent[x])
    return parent[x] 

def union_parent(x,y):
    x = find_parent(x)
    y = find_parent(y)
    if x < y:
        parent[y] = x
    else :
        parent[x] = y

for _ in range(edge):
    node1,node2 = map(int,sys.stdin.readline().strip().split())
    union_parent(node1,node2)
    
rootSet = set()
for i in range(1,len(parent)):
    find_parent(i)
    rootSet.add(parent[i])

print(len(rootSet))
