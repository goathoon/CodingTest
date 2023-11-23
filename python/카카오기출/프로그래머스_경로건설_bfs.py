from collections import deque

def solution(board):
    n = len(board)
    direction = [[1,0,0],[0,1,1],[-1,0,2],[0,-1,3]]
    
    dp = [[[987654321] * (n) for _ in range(n)] for _ in range(4)]
    q = deque()
    q.append((0,0,1,0))
    q.append((0,0,0,0))

    
    while q:
        row,col,d,cost = q.popleft()
        # 아래 처럼 하면 안됨. 항상 최소 dp로 갱신
        # dp[d][row][col] = cost
        for di in direction:
            new_row = di[0] + row
            new_col = di[1] + col
            if new_row < 0 or new_row >= n or new_col < 0 or new_col >= n or board[new_row][new_col] == 1:
                continue
            add_cost = 100
            if di[2] != d :
                add_cost += 500
            # 절대 이에게 등호를 붙이지마
            if dp[di[2]][new_row][new_col] > cost + add_cost:
                dp[di[2]][new_row][new_col] = cost + add_cost
                if new_row == n-1 and new_col == n-1:
                    continue
                q.append((new_row,new_col,di[2],cost+add_cost))
                
    answer = 987654321
    for i in range(4):
        answer = min(dp[i][n-1][n-1],answer)
    return answer