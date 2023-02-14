from collections import deque
N = int(input())

graph = []
visit = [[0] * N for _ in range(N)]
pos_dict= {i:[] for i in range(1,7)} 
#dictionary for문 초기화 방법 알아둘것.
#key = 물고기 크기, value = 물고기 위치

for row in range(N):
    row_arr = list(map(int,input().split()))
    graph.append(row_arr)
    for col in range(N):
        if row_arr[col] == 9:
            move_pos = (row,col)
            graph[row][col] = 0
            continue
        if row_arr[col] != 0:
            pos_dict[row_arr[col]].append((row,col))

move_size = 2

def bfs(start_pos,move_size,end_pos):
    dx = [1,0,-1,0]
    dy = [0,-1,0,1]
    q = deque()
    q.append((start_pos[0],start_pos[1],0))
    while q:
        y,x,dist = q.popleft()
        if x == end_pos[1] and y == end_pos[0] :
            return dist
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0<=nx<N and 0<=ny<N and graph[ny][nx] <= move_size and visit[ny][nx] == 0:
                q.append((ny,nx,dist+1))
                visit[ny][nx] = 1
    return 987654321
                
# 본격적인 구현 코드
pos_set = set(pos_dict[1])
ans = 0
size_up = 0
while True:
    if move_size <= 6 and size_up == move_size:
        move_size += 1
        pos_set.update(pos_dict[move_size-1])
        size_up = 0
        
    if len(pos_set) == 0:
        print(ans)
        break
    
    pos_sort = sorted(pos_set,key=lambda x : abs(x[0]-move_pos[0])+abs(x[1]-move_pos[1]))
    dist_list =[]
    for pos in pos_sort:
        dist = bfs(move_pos,move_size,pos)
        visit = [[0] * N for _ in range(N)]
        dist_list.append((pos[0],pos[1],dist))
    dist_list.sort(key = lambda x : (-x[2],-x[0],-x[1])) # 정렬을 dist 내림차순으로 해서, 가장 짧은 dist를 마지막 원소로 만들어서 pop하기 쉽게함
    pop_ele = dist_list.pop()
    
    
    move_pos = (pop_ele[0],pop_ele[1])
    
    #디버그
    #print(move_pos,move_size)
    #
    pos_set.remove(move_pos)
    if pop_ele[2] == 987654321:
        print(ans)
        break
    ans += pop_ele[2]
    size_up +=1

#print(graph)