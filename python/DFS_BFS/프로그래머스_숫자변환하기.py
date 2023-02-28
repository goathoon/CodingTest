from collections import deque


def solution(x, y, n):
    answer = 0
    visit = [0] * 1000001

    q = deque()
    q.append((0, x))
    visit[x] = 1

    while q:
        now_cnt, now = q.popleft()
        if now == y:
            return now_cnt
        if now + n <= 1000000 and visit[now+n] == 0:
            q.append((now_cnt+1, now+n))
            visit[now+n] = 1
        if now*3 <= 1000000 and visit[now*3] == 0:
            q.append((now_cnt+1, now*3))
            visit[now*3] = 1
        if now*2 <= 1000000 and visit[now*2] == 0:
            q.append((now_cnt+1, now*2))
            visit[now*2] = 1

    return -1
