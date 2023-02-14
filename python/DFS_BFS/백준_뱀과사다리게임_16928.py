from collections import deque
up, down = map(int,input().split())
move_dict = {}
visit = [0] * 101
for _ in range(up+down):
    start,end = map(int,input().split())
    move_dict[start] = end

q = deque()
start = 1
q.append((start,0))

while q:
    now = q.popleft()
    now_pos = now[0]
    now_cnt = now[1]
    if now_pos == 100:
        print(now_cnt)
        break
    for i in range(1,7):
        if now_pos + i <= 100 and visit[now_pos+i] == 0 :
            if now_pos + i in move_dict and visit[move_dict[now_pos+i]] == 0:
                visit[move_dict[now_pos+i]] = 1
                q.append((move_dict[now_pos+i],now_cnt+1))
                continue
            elif now_pos + i not in move_dict: # 사다리,뱀 은 visit 체크하면 안됨 ! 계속 방문가능케 해야 더 빠른 경우도 있을 수 있기 때문이다.
                visit[now_pos+i] = 1
                q.append((now_pos+i,now_cnt+1))
            