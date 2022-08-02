class Solution(object):
    maxArea = 0 
    area = 0
    def maxAreaOfIsland(self, grid):
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 1 :
                    self.area += 1
                    self.dfs(grid,col,row)
                    self.maxArea = max(self.maxArea,self.area)
                    self.area = 0
        
        return self.maxArea


    
    
    def dfs(self,grid,x,y):
        grid[y][x] = 0 #visited 를 그냥 0으로 바꿔버리자.
        dx = [1,-1,0,0]
        dy = [0,0,-1,1]
        for i in range(4):
            if x + dx[i] <0 or x + dx[i] >= len(grid[0]) or y + dy[i] <0 or y+ dy[i] >= len(grid):
                continue
            else:
                if grid[y+dy[i]][x+dx[i]] == 1:
                    self.dfs(grid,x+dx[i],y+dy[i])
                    self.area += 1
