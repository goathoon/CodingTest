com = int(input())
edge = int(input())
grid=[[]*(com+1) for _ in range(com+1)]
visit = [0] * (com+1)
for _ in range(edge):
    node1,node2 = map(int,input().split())
    grid[node1].append(node2)
    grid[node2].append(node1)

global answer
answer = 0
def dfs(node):
    if visit[node] == 1:
        return
    global answer
    answer += 1
    visit[node] = 1
    for computer in grid[node]:
        dfs(computer)

dfs(1)
print(answer-1)