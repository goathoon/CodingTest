class Solution:
    def __init__(self):
        self.answer = True

    def isBipartite(self, graph: List[List[int]]) -> bool:
        self.visit = [0] * len(graph)
        for i in range(len(graph)):
            if self.visit[i] == 0:
                self.dfs(graph, i, self.visit, self.visit[i])
        print(self.visit)
        return self.answer

    # 각 노드별 path들의 bipartite를 기록하면서 bipartite를 체크하는 함수
    def dfs(self, graph, node, visit, check):
        if check == 1:
            # check인자로 1이 넘어왔으면 현재 체크하는 노드는 반드시 -1인 노드여야함.
            if visit[node] == 1:
                self.answer = False
                return
            elif visit[node] == -1:
                return
            visit[node] = -1
        elif check == -1:
            if visit[node] == -1:
                self.answer = False
                return
            elif visit[node] == 1:
                return
            visit[node] = 1
        else:
            visit[node] = -1
        for pair in graph[node]:
            # 절대 return하면 안됨 그 이유는 생각해볼것
            self.dfs(graph, pair, self.visit, visit[node])
