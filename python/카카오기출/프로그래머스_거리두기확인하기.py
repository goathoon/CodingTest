def solution(places):
    answer = []
    
    for place in places:        
        if check_dist(place) is False:
            answer.append(0)
            continue
        else:
            answer.append(1)
    
    return answer

def check_dist(place):
    for row in range(5):
        for col in range(5):
            if place[row][col] == 'P':
                if in_one_dist(place,row,col) is False: 
                    return False
                if in_two_dist(place,row,col) is False:
                    return False
    return True
                    
                        
def in_one_dist(place,row,col):
    dx = [1,0,-1,0]
    dy = [0,-1,0,1]
    for i in range(4):
        if row + dy[i] > 4 or row+dy[i] < 0 or col + dx[i] > 4 or col + dx[i] < 0 :
            continue
        if place[row+dy[i]][col+dx[i]] == 'P':
            return False
    return True

def in_two_dist(place,row,col):
    move_dir = [(-2,0),(-1,1),(0,2),(1,1),(2,0),(1,-1),(0,-2),(-1,-1)]    
    for mov in move_dir : 
        row_mov = mov[0]
        col_mov = mov[1]
        if row + row_mov > 4 or row + row_mov < 0 or col + col_mov > 4 or col + col_mov < 0 :
            continue
        if place[row+row_mov][col+col_mov] == 'P':
            if abs(row_mov) == 1 :
                if is_X_cross(place,row,col,mov) is False:
                    return False
            else :
                if is_X_straight(place,row,col,mov) is False:
                    return False
    return True
                
                
            
def is_X_cross(place,row,col,mov):
    if mov == (-1,1):
        if place[row-1][col] == 'X' and place[row][col+1] == 'X':
            return True
    elif mov == (-1,-1):
        if place[row-1][col] == 'X' and place[row][col-1] == 'X':
            return True
    elif mov == (1,1):
        if place[row+1][col] == 'X' and place[row][col+1] == 'X':
            return True
    elif mov ==(1,-1):
        if place[row+1][col] == 'X' and place[row][col-1] == 'X':
            return True
    return False
def is_X_straight(place,row,col,mov):
    if mov == (2,0):
        if place[row+1][col] == 'X':
            return True
    elif mov == (-2,0):
        if place[row-1][col] == 'X':
            return True
    elif mov == (0,2):
        if place[row][col+1] == 'X':
            return True
    elif mov ==(0,-2):
        if place[row][col-1] == 'X':
            return True
    return False
    
        