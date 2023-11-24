import heapq

def solution(n, paths, gates, summits):
    adj_list = {i : [] for i in range(1,n+1)}
    summit_dict = {i : False for i in range(1,n+1)}
    for s in summits:
        summit_dict[s] = True
    inf = int(1e9)
    intensity = [inf]*(n+1)
    
        
    for p in paths:
        start, end, cost = p[0], p[1], p[2]
        adj_list[start].append((end,cost))
        adj_list[end].append((start,cost))
    for g in gates:
        heap = []
        intensity[g] = 0
        #최초 탐색
        for v in adj_list[g]:
            node, cost = v[0],v[1]
            if intensity[node] < cost:
                continue
            intensity[node] = cost
            heapq.heappush(heap,(cost,node))
        while heap:
            cost, node = heapq.heappop(heap)
            
            ## 해당 코드를 넣지 않으면 시간 초과가 발생함 ##
            if intensity[node] < cost:
                continue
            ######################################
            
            if summit_dict[node] == True:
                continue
            for v in adj_list[node]:
                v_node, v_cost = v[0],v[1]
                new_cost = max(cost,v_cost)
                if intensity[v_node] <= new_cost:
                    continue
                intensity[v_node] = new_cost
                heapq.heappush(heap,(new_cost,v_node))
    num = -1
    minimum = inf
    summits.sort()
    for s in summits:
        if minimum == intensity[s] :
            continue
        else:
            minimum = min(minimum,intensity[s])
            if minimum == intensity[s]:
                num = s
        
    answer = [num,minimum]
    return answer