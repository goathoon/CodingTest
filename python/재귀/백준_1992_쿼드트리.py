import sys
N = int(input())
graph = []
for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().strip())))
answer = []


def quad(row, col, N):
    if N == 1:
        answer.append(graph[row][col])
        return
    num = graph[row][col]
    for i in range(row, row+N):
        for j in range(col, col+N):
            if graph[i][j] != num:
                answer.append('(')
                quad(row, col, N//2)
                quad(row, col+N//2, N//2)  # for문을 앞에거 계쇽 받음
                quad(row+N//2, col, N//2)
                quad(row+N//2, col+N//2, N//2)
                answer.append(')')
                return
    answer.append((graph[row][col]))


quad(0, 0, N)
for i in range(len(answer)):
    print(answer[i], end='')
