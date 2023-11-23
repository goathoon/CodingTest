def solution(n, k, cmd):
    nodes = {i:[i-1,i+1] for i in range(0,n)}
    length = n
    nodes[0] = [None,1]
    nodes[n-1] = [n-2,None]
    
    pointer = k
    curr_node = nodes[k]
    
    erase_value = []
    for c in cmd:
        parsed = c.split()
        if parsed[0] == 'D':
            cnt = int(parsed[1])
            for _ in range(cnt):
                pointer = curr_node[1]
                curr_node = nodes[pointer]
        elif parsed[0] == 'U':
            cnt = int(parsed[1])
            for _ in range(cnt):
                pointer = curr_node[0]
                curr_node = nodes[pointer]
        elif parsed[0] == 'C':
            prev_value = curr_node[0] 
            next_value = curr_node[1]
            if next_value == None:
                nodes[prev_value][1] = None
                erase_value.append(pointer)
                pointer = prev_value
            elif prev_value == None:
                nodes[next_value][0] = None
                erase_value.append(pointer)
                pointer = next_value
            else:
                nodes[prev_value][1] = next_value
                nodes[next_value][0] = prev_value
                erase_value.append(pointer)
                pointer = next_value
            curr_node = nodes[pointer]
        else:
            last_pointer = erase_value.pop()
            if nodes[last_pointer][0] is not None:
                prev_value = nodes[last_pointer][0]
                nodes[prev_value][1] = last_pointer
            if nodes[last_pointer][1] is not None:
                next_value = nodes[last_pointer][1]
                nodes[next_value][0] = last_pointer
            
            curr_node = nodes[pointer]
        
    answer = ['O']*n
    print(erase_value)
    while erase_value:
        erase_idx = erase_value.pop()
        answer[erase_idx] = 'X'
    return ''.join(answer)
            
print(solution(8,2,["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"]))
