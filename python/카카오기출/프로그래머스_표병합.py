def init_parent_cell(cell):
    for row in range(1,len(cell)):
        for col in range(1,len(cell[0])):
            cell[row][col] = (row,col)

def solution(commands):
    global cell
    cell = [["EMPTY" for _ in range(51)] for _ in range(51)]
    global parent_cell
    parent_cell = [[0 for _ in range(51)] for _ in range(51)]
    init_parent_cell(parent_cell)
    
    answer = []
    for command in commands:
        do(command,answer)
            
    
    
    return answer

# Unmerge시 초기 상태를 유지하기 위해 parent_cell과 cell을 나누었습니다.
def do(command,answer):
    parsed = command.split();
    if parsed[0] == "UPDATE":
        if len(parsed) == 4:
            target_row, target_col = parsed[1],parsed[2]
            content = parsed[3]
            
            update_idx = find_parent(int(target_row),int(target_col))
            cell[update_idx[0]][update_idx[1]] = content
        else:
            before_content,content = parsed[1],parsed[2]
            for row in range (1,51):
                for col in range(1,51):
                    if cell[row][col] == before_content:
                        cell[row][col] = content
    elif parsed[0] == "MERGE":
        r1,c1,r2,c2 = int(parsed[1]),int(parsed[2]),int(parsed[3]),int(parsed[4])
        union(r1,c1,r2,c2)
    elif parsed[0] == "UNMERGE":
        r1,c1 = int(parsed[1]),int(parsed[2])
        un_union(r1,c1)
    elif parsed[0] == "PRINT":
        r1,c1 = int(parsed[1]),int(parsed[2])
        answer.append(cell[find_parent(r1,c1)[0]][find_parent(r1,c1)[1]])
            
def find_parent(row,col):
    if parent_cell[row][col] != (row,col):
        parent_cell[row][col] = find_parent(parent_cell[row][col][0],parent_cell[row][col][1])
    return parent_cell[row][col]

def union(r1,c1,r2,c2):
    if (r1,c1) == (r2,c2):
        return
    
    first_parent_cell_idx = find_parent(r1,c1) 
    second_parent_cell_idx = find_parent(r2,c2)
    
    if cell[first_parent_cell_idx[0]][first_parent_cell_idx[1]] != "EMPTY":
        update_parent(parent_cell[r2][c2][0],parent_cell[r2][c2][1],first_parent_cell_idx[0],first_parent_cell_idx[1])
        parent_cell[r2][c2] = (first_parent_cell_idx[0],first_parent_cell_idx[1])
    else:
        if cell[second_parent_cell_idx[0]][second_parent_cell_idx[1]] != "EMPTY":
            update_parent(parent_cell[r1][c1][0],parent_cell[r1][c1][1],second_parent_cell_idx[0],second_parent_cell_idx[1])
            parent_cell[r1][c1] = (second_parent_cell_idx[0],second_parent_cell_idx[1])
        else:
            update_parent(parent_cell[r2][c2][0],parent_cell[r2][c2][1],first_parent_cell_idx[0],first_parent_cell_idx[1])
            parent_cell[r2][c2] = (first_parent_cell_idx[0],first_parent_cell_idx[1])
def update_parent(before_row,before_col,new_row,new_col):
    for row in range(1,51):
        for col in range(1,51):
            if parent_cell[row][col] == (before_row,before_col):
                parent_cell[row][col] = (new_row,new_col)
def un_union(r,c):
    (parent_r,parent_c) = find_parent(r,c)
    
    prior_content = cell[parent_r][parent_c] 
    if prior_content != "EMPTY":
        init_when_un_union(parent_r,parent_c)
        cell[r][c] = prior_content
        
    else:
        init_when_un_union(parent_r,parent_c)
        
def init_when_un_union(parent_r,parent_c):
    for row in range(1,51):
        for col in range(1,51):
            if parent_cell[row][col] == (parent_r,parent_c):
                cell[row][col] = "EMPTY"
                parent_cell[row][col] = (row,col)
    
    
        
            
            

    