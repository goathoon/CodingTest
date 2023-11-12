from collections import deque
def solution(maps):
    answer = 0
    
    queue = deque()
    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    
    row_move = [1,0,-1,0]
    col_move = [0,-1,0,1]
    
    queue.append((0,0,answer + 1))
    visited[0][0] = True
    while queue:
        row,col,answer = queue.popleft()
        if row == len(maps)-1 and col == len(maps[0])-1:
            return answer 

        for i in range(4):
            after_move_row = row + row_move[i]
            after_move_col = col + col_move[i]
            if after_move_row >= len(maps) or after_move_row < 0 :
                continue
            if after_move_col >= len(maps[0]) or after_move_col < 0 :
                continue
            
            if maps[after_move_row][after_move_col] == 0 or visited[after_move_row][after_move_col] == True :
                continue
            
            queue.append((after_move_row,after_move_col,answer+1))
            visited[after_move_row][after_move_col] = True

    
    return -1