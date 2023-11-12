def dfs(start_com,computers):
    visited[start_com] = True
    for next_com, is_connect in enumerate(computers[start_com]) :
        if not visited[next_com] and is_connect == 1 and next_com != start_com:
            dfs(next_com,computers)
        
            

def solution(n, computers):
    global visited
    visited = [False] * n
    answer = 0
    
    for start_com in range(n):
        if not visited[start_com] :
            dfs(start_com,computers)
            answer += 1
    return answer