from collections import deque


def solution(maps):
    answer = 0
    lever_check = False
    visit = [[0]*(len(maps[0])+1) for _ in range(len(maps)+1)]
    for str_idx in range(len(maps)):
        for char_idx in range(len(maps[str_idx])):
            if maps[str_idx][char_idx] == "S":
                start = (str_idx, char_idx)
            elif maps[str_idx][char_idx] == "E":
                end = (str_idx, char_idx)
            elif maps[str_idx][char_idx] == "L":
                lever = (str_idx, char_idx)
    q = deque()
    q.append((0, start[0], start[1]))
    dx = [1, 0, -1, 0]
    dy = [0, -1, 0, 1]
    while q:
        cnt, row, col = q.popleft()
        if row == lever[0] and col == lever[1]:
            answer += cnt
            lever_check = True
            break
        for i in range(4):
            nx = col + dx[i]
            ny = row + dy[i]
            if 0 <= nx < len(maps[0]) and 0 <= ny < len(maps) and visit[ny][nx] == 0 and maps[ny][nx] != 'X':
                q.append((cnt+1, ny, nx))
                visit[ny][nx] = 1
    if not lever_check:
        return -1

    q.clear()
    visit = [[0]*(len(maps[0])+1) for _ in range(len(maps)+1)]
    q.append((0, lever[0], lever[1]))
    while q:
        cnt, row, col = q.popleft()
        if row == end[0] and col == end[1]:
            answer += cnt
            return answer
            break
        for i in range(4):
            nx = col + dx[i]
            ny = row + dy[i]
            if 0 <= nx < len(maps[0]) and 0 <= ny < len(maps) and visit[ny][nx] == 0 and maps[ny][nx] != 'X':
                q.append((cnt+1, ny, nx))
                visit[ny][nx] = 1
    return -1
