import sys
sys.setrecursionlimit(10**6)

def solution(board):
    inf = int(1e9)
    n = len(board)
    memo = [[[inf] * n for _ in range(n)] for _ in range(4)]
    direction = [[1,0,0],[0,1,1],[-1,0,2],[0,-1,3]]
    dfs(0,0,0,0,memo,direction,board)
    dfs(0,0,1,0,memo,direction,board)
    answer = inf
    for i in range(4):
        answer = min(answer,memo[i][n-1][n-1])
    return answer

def dfs(row,col,move,cost,memo,direction,board):
    for direct in direction:
        drow = direct[0]
        dcol = direct[1]
        didx = direct[2]
        if 0 <= row+drow <= len(memo[didx]) -1 and 0 <= col+dcol <= len(memo[didx][0])-1 and board[row+drow][col+dcol] == 0:
            new_cost = cost + 100
            if move != didx:
                new_cost += 500
            if memo[didx][row+drow][col+dcol] > new_cost:
                memo[didx][row+drow][col+dcol] = new_cost
                dfs(row+drow,col+dcol,didx,new_cost,memo,direction,board)
        