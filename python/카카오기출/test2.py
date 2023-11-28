import sys
sys.setrecursionlimit(10**7)
def solution(edges):
    start_node = set()
    end_node = set()
    node_dict = {}
    for e in edges:
        s,e = e[0],e[1]
        end_node.add(e)
        if s in node_dict:
            node_dict[s].append(e)
            if len(node_dict[s]) >= 2:
                if s not in end_node :
                    start_node.add(s)
        else:
            node_dict[s] = [e]
        if e not in node_dict:
            node_dict[e] = []


    # 생성노드가 여러개일때, 그래프에 포함되지 않은 노드를 찾는 과정       
    if len(start_node) > 1:
        for s in start_node:
            length = 0
            done= False
            for e in edges:
                if e[0] == s:
                    length += 1
                    if length > 1:
                        start_node = set({s})
                        done = True
                        break
            if done:
                break
    for s in start_node:
        new_node = s

    # 나가는거 2개 -> 들어오는거 2개인 녀석의 노드가 한 집합안에 있는 경우 -> 팔자
    # 나가는거 1개 or 들어오는거 1개만 있는 노드가 1개 있으면 -> 막대
    # 모조리 나가는거 1개 들어오는거 한개인 경우 or 자기자신을 포함한 경우(유일) -> 도넛
    answer = [new_node,0,0,0]
    visit = [0] * 1000001
    for e in edges:
        if e[0] == new_node:
            answer[get_kind(e[1],node_dict,visit)] += 1
    return answer

def get_kind(s,node_dict,visit):
    visit[s] = 1
    if len(node_dict[s]) >= 2:
        return 3
    elif len(node_dict[s]) == 1:
        if node_dict[s][0] == s :
            return 1
        ## 여기부터가 일반적인 경우 (나가는게 하나 들어오는게 하나)
        else :
            if visit[node_dict[s][0]] == 0:
                return get_kind(node_dict[s][0],node_dict,visit)
            else:
                return 1
    else:
        return 2