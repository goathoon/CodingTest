from collections import deque
q = deque()

N,M,H = map(int,input().split())
grid = list()

drow = [1,-1,0,0,0,0]
dcol = [0,0,1,-1,0,0]
dheight = [0,0,0,0,1,-1]
beYes = 0 #익어야할 토마토의 개수를 저장하는 변수
#토마토통에 토마토를 넣는 iteration
for height in range(H):
    for row in range(M):
        line = list(map(int,input().split())) # 한 라인 input값을 line 변수에 저장
        beYes += line.count(0)
        grid.append(line) #순차적으로 grid라는 토마토통에 배열형태로 넣습니다.
#visited 리스트 따로 선언
visited = [[False] * N for _ in range(M*H)] #0이면 방문 X

def bfs(grid, visited, x, y, z):
    for i in range(6):
        # 유효 범위를 벗어난 경우
        if (x + dcol[i] >= len(grid[0]) or x + dcol[i] < 0 
            or y + drow[i] >= len(grid)/H or y + drow[i] < 0
            or z + dheight[i] >= H or z + dheight[i] < 0): #높이도 0을 DEFAULT 로 두었다.
                continue
        #유효 범위에 포함된 경우
        else:
            #방문하지 않은 익지않은 토마토를 발견
            if (not visited[y+drow[i] + M * (z+dheight[i])][x+dcol[i]] and
                grid[y+drow[i] + M * (z+dheight[i])][x+dcol[i]] == 0): 
                    q.append((x+dcol[i],y+drow[i],z+dheight[i])) # 그 위치의 grid의 좌표를 큐에 삽입
                
            visited[y+drow[i] + M * (z+dheight[i])][x+dcol[i]] = True # 방문 grid를 표현.
                #3차원을 2차원으로 표현. 인덱스만 신경써주면 된다. 높이가 list에
                #연속해서 쌓임. col(열<가로>의 수)는 변하지 않되, row(행<세로>의 수)는 높이에 따라 변한다. 
                #쌓아올린 탑(상자)들을 1층으로 만든다고 생각하면 됨. 'ㅁ x 6'을 ㅁㅁㅁㅁㅁㅁ 으로
                #이를 주어진 높이인 H를 곱해서 나타낼 수있다.

#제일 처음 익은 토마토를 발견했을때 bfs를 돌린다. 그럼 원래부터 익은 토마토를 발견한 좌표를 큐에 append함.
for row in range(len(grid)):
    for col in range(len(grid[0])):
        if grid[row][col] == 1: #익은 토마토 발견
            bfs(grid,visited,col,row%M,row//M) # row % M 을 하면 층별 row가 나옴. row//M을 하면 층수가 나옴 

#원래부터 익은 토마토의 위치가 큐에 존재하는 상태에서 시작.
#큐에 있는 익은 토마토 위치 좌표들을 싹다 비우고 tmpStack에 추가후, 다시 그 토마토들을  tmpStack 저장되어있는 애들을 빼내면서
# 1로 바꾸고, 이 친구들이 영향주는 다른 토마토들을 q에 append
# 그후 일 수를 추가.

no2Yes = 0 #안익은 토마토에서 익은 토마토로 바꾼 개수. 얘가 divCnt와 같아지면 다 익은 거임.
day = 0
tmpStack = list()
while(beYes != no2Yes):
    if not q: # beYes 가 no2Yes가 아니라는 소리는 모든 토마토가 안익었고, 그리고 not q란 소리는,
              # 이후에 영향받을 토마토가 없다는 소리이므로, 모든 토마토를 다 익게할 수 없다.
        break
    while(q):
        x = q.popleft()
        tmpStack.append(x)
    #tmpStack에 저장되어있는 익어야할 토마토의 좌표들을 하나씩 빼내면서 익히고, 다시 bfs시작
    while(tmpStack):
        spreadIndex = tmpStack.pop()
        grid[spreadIndex[1]+M*spreadIndex[2]][spreadIndex[0]] = 1 # 익은 토마토로 바꾸고,
        no2Yes += 1 #no2Yes 변수 1 추가.
        bfs(grid,visited,spreadIndex[0],spreadIndex[1],spreadIndex[2]) # 거기서 bfs시작.
    day += 1
    
if beYes!= no2Yes:
    print(-1)
else:
    print(day)
    
        