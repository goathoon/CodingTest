N,M = map(int,input().split())
start_X, start_Y, start_D = map(int,input().split())
gird=[start_X][start_Y] = 1 #방문한 곳 1로 처리.
visited = [[0]*M for _ in range(N)] #방문 지도 만듦. 컴프리헨션

#전체 맵 정보 입력 받기
array = []
for i in range(N):
    array.append(list(map(int,input().split())))

#동서남북
dx = [-1,0, 1,0]
dy = [0,1,0,-1]

#왼쪽으로 회전
def turn_left():
    global start_D
    start_D -= 1
    if start_D == -1:
        start_D= 3

count = 1
turn_time =0
while True:
    #왼쪽으로 회전
    turn_left()
    nx = start_X + dx[start_D]
    ny = start_Y + dy[start_D]
    #회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
    if