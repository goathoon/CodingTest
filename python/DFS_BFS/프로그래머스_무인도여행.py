import sys
sys.setrecursionlimit(10**9)


def solution(maps):
    answer = []
    visit = [[0] * len(maps[0]) for _ in range(len(maps))]
    for row in range(len(maps)):
        for col in range(len(maps[0])):
            if visit[row][col] == 0 and maps[row][col] != 'X':
                append_num = dfs(int(maps[row][col]), maps, visit, row, col)
                answer.append(append_num)
    answer.sort()
    if not answer:
        answer.append(-1)

    return answer


def dfs(cnt, maps, visit, row, col):
    visit[row][col] = 1
    dx = [0, -1, 0, 1]
    dy = [-1, 0, 1, 0]

    for i in range(4):
        ny = row+dy[i]
        nx = col+dx[i]
        if 0 <= nx < len(maps[0]) and 0 <= ny < len(maps) and maps[ny][nx] != 'X' and visit[ny][nx] == 0:
            cnt = dfs(cnt+int(maps[ny][nx]), maps, visit, ny, nx)
    return cnt
