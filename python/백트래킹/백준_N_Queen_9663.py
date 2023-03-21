n = int(input())
visit = [0]*n
ans = 0
# visit 은 필수적이다. 하지만 이차원을 통째로 바꾸는 것은 시간낭비 조짐..
"""
1차원 visit배열을 만들되,
문제 특성상, row별 한개의 퀸만 들어갈 수 있으므로,
visit 배열의 인덱스는 row이고,
원소들은 각 row에 들어갈 col값으로 하면, 쉽게 visit 체크가 가능해진다.
"""


def check(row):  # 해당 행에 존재하는 퀸 위치가 가능한 위치인지 체크
    for i in range(row):  # 이전 행까지 체크

        # 첫번째 조건문은 같은 열일 경우,
        # 두번째 조건문은 대각선에 존재할 경우
        if visit[i] == visit[row] or abs(visit[i]-visit[row]) == abs(i-row):
            return False
    return True


def dfs(x):
    global ans
    if x == n:
        ans += 1
        return
    for col in range(1, n+1):
        visit[x] = col
        if check(x):
            dfs(x+1)
        # else: 굳이 안해도 된다. (백트래킹부분임) 어차피 갱신되고, check함수에서 뒤에거는 체크 안하므로
        #     visit[x] = 0


dfs(0)
print(ans)
