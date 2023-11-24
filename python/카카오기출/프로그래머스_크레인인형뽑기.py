def solution(board, moves):
    stack = []
    answer = 0
    for move in moves:
        thing = get_top(board,move)
        if thing == 0:
            continue
        stack.append(thing)
        if len(stack) >= 2:
            if stack[-1] == stack[-2] :
                answer += 2
                stack.pop()
                stack.pop()
        
    
    return answer

def get_top(board,pos):
    n = len(board)
    idx = pos - 1
    for i in range(n):
        if board[i][idx] != 0:
            top = board[i][idx] 
            board[i][idx] = 0
            return top
    return 0 
        