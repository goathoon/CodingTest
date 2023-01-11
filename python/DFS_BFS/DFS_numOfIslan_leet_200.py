# class Solution(object):
#     def numIslands(self, grid):
#         count = 0
#         global gridVisited
#         gridVisited = [[False] * len(grid[0]) for _ in range(len(grid))]
#         self.maxRow = len(grid)
#         self.maxCol = len(grid[0])

#         for row in range(len(grid)):  # grid 좌표들을 쭉 방문하면서 '1' 랜드인 곳부터 dfs를 시작한다.
#             for col in range(len(grid[0])):
#                 if gridVisited[row][col] == False:
#                     if grid[row][col] == "1":
#                         count += 1
#                         self.dfs(grid,gridVisited,row,col)
#                     else:
#                         gridVisited[row][col] = True
#         return count
                        
#     def dfs(self,grid,gridVisited,row,col):
#         dx = [1,-1,0,0]
#         dy = [0,0,1,-1]
#         gridVisited[row][col] = True #방문 처리
#         for i in range(4):
#             if (row + dy[i] >= 0 and row + dy[i] < self.maxRow and col + dx[i] >= 0 and col + dx[i] < self.maxCol and 
#                 gridVisited[row + dy[i]][col + dx[i]] == False
#                 and grid[row+dy[i]][col+dx[i]] == '1') :
#                     self.dfs(grid,gridVisited,row+dy[i],col+dx[i])

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.visited =[['0']*len(grid[0]) for _ in range(len(grid))]
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1' and not self.visited[i][j] == '1':
                    self.dfs(grid,i,j)
                    count +=1
        return count
    def dfs(self,grid,i,j):
        if i+1 < len(grid) and not self.visited[i+1][j] == '1' and grid[i+1][j] == '1':
            self.visited[i+1][j] = '1' #visit 먼저 해야 dfs 재귀돌면서 조건문에 걸리기 때문에 스택오버 방지 가능
            self.dfs(grid,i+1,j) #남쪽
        
        if j+1 < len(grid[0]) and not self.visited[i][j+1] == '1' and grid[i][j+1] == '1':
            self.visited[i][j+1] = '1'
            self.dfs(grid,i,j+1) #동쪽

        #서쪽
        if j-1 >= 0 and not self.visited[i][j-1] == '1' and grid[i][j-1] == '1':
            self.visited[i][j-1] = '1'
            self.dfs(grid,i,j-1) #서쪽

        if i-1>= 0 and not self.visited[i-1][j] == '1' and grid[i-1][j] == '1' :
            self.visited[i-1][j] = '1'
            self.dfs(grid,i-1,j)