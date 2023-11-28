def solution(edges):
    start_end_dict = {}
    end_start_dict = {}
    cand_node = []
    new_node = -1
    for e in edges:
        s,e = e[0],e[1]
        if s in start_end_dict:
            start_end_dict[s].append(e)
            end_start_dict[e].append(s)
            if len(start_end_dict[s]) > 2:
                new_node = s
            elif len(start_end_dict[s]) == 2:
                if new_node == -1:
                    cand_node.append(s)
        else:
            start_end_dict[s] = [e]
            end_start_dict[e] = [s]
    if new_node == -1:
        while cand_node:
            node = cand_node.pop()
            if len(end_start_dict[node]) == 1:
                new_node = node
                break
    print(new_node)
solution([[2, 3], [4, 3], [1, 1], [2, 1]])