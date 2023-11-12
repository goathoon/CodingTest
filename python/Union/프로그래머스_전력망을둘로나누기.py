import copy

def solution(n, wires):
    def find_parent(x):
        if parent[x] != x:
            parent[x] = find_parent(parent[x])
        return parent[x]
    
    def union_parent(x,y):
        x = find_parent(x)
        y = find_parent(y)
        if x < y:
            parent[y] = x
        else :
            parent[x] = y
    
    answer = 987654321

    for wire in wires:
        parent = [i for i in range(n+1)]

        wires_after_removed = copy.deepcopy(wires)
        wires_after_removed.remove(wire)
        
        
        for wire in wires_after_removed:
            union_parent(wire[0],wire[1])
        
        for i in range(1,n+1):
            find_parent(i)
        
        answer = min(answer,abs(parent.count(parent[1]) - (n-parent.count(parent[1]))))
    return answer