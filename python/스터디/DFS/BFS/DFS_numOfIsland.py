class Solution(object):
    def numIslands(self, grid):
        count = 0
        global gridVisited
        gridVisited = [[False] * len(grid[0]) for _ in range(len(grid))]
        self.maxRow = len(grid)
        self.maxCol = len(grid[0])

        for row in range(len(grid)):  # grid 좌표들을 쭉 방문하면서 '1' 랜드인 곳부터 dfs를 시작한다.
            for col in range(len(grid[0])):
                if gridVisited[row][col] == False:
                    if grid[row][col] == "1":
                        count += 1
                        self.dfs(grid,gridVisited,row,col)
                    else:
                        gridVisited[row][col] = True
        return count
                        
    def dfs(self,grid,gridVisited,row,col):
        dx = [1,-1,0,0]
        dy = [0,0,1,-1]
        gridVisited[row][col] = True #방문 처리
        for i in range(4):
            if (row + dy[i] >= 0 and row + dy[i] < self.maxRow and col + dx[i] >= 0 and col + dx[i] < self.maxCol and 
                gridVisited[row + dy[i]][col + dx[i]] == False
                and grid[row+dy[i]][col+dx[i]] == '1') :
                    self.dfs(grid,gridVisited,row+dy[i],col+dx[i])