import sys
N = int(input())
graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))

global answer_neg
global answer_zer
global answer_one
answer_neg = 0
answer_zer = 0
answer_one = 0
global cnt
cnt = 0


def countNum(row, col, n):  # 각 graph의 전체 구역을 탐색하면서, 다 같은 수인지 확인 및 아니라면 재귀함수호출하면서 정답 수를 갱신하는 함수
    # i,j 는 graph 전체의 시작 인덱스 , n은 각 시작 인덱스별로 몇개까지 구역을 나눌건지 체크, 0,0,3이라면 0,0에서부터 시작되는 길이가 3인 정사각형을 의미
    global answer_neg
    global answer_zer
    global answer_one
    check_set = set()
    for i in range(row, row+n):
        check_set.update(graph[i][col:col+n])
    if len(check_set) != 1:
        for i in range(3):
            for j in range(3):
                countNum(row+n*i//3, col+n*j//3, n//3)

    else:
        ele = list(check_set)
        if ele[0] == 1:
            answer_one += 1
            return
        elif ele[0] == -1:
            answer_neg += 1
            return
        else:
            answer_zer += 1
            return


countNum(0, 0, N)
print(answer_neg)
print(answer_zer)
print(answer_one)
