from collections import deque
class Solution(object):
    #최소를 구할떄 BFS 를 쓴다.
    def coinChange(self, coins, amount):
        queue = deque()
        visited = [False] * (amount+1) #방문 노드 체크 리스트(amount)기준
        queue.append((amount,0)) # 0 은 노드의 hegiht를 의미함. 즉, amount 와 그 노드의 height를 queue에 삽입
                                      # 이때 height 는 동전의 개수가 될 수 밖에 없다.
        visited [amount] = True
        while queue : # 큐가 비어있지 않다면.
            prior = queue.popleft()
            if prior[0] == 0 : # amount가 0이 되었음. 탐색을 종료. (최소 동전의 개수임)
                return prior[1]
            for coin in coins: #코인의 총 종류별로 하나씩 방문하며 이전 amount에서 빼고, 노드의 height를 1씩 추가.
                if prior[0] - coin >= 0 : 
                    if not visited[prior[0] - coin] :
                        queue.append((prior[0]-coin,prior[1]+1)) # amount에서 coin을 지불한 가격인 amount -coin과, hegiht 1증가한 노드 삽입. 
                        visited[prior[0] - coin] = True
        return -1
   
