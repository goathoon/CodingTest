grid = [
    ["1", "1", "1", "1", "0"],
    ["1", "1", "0", "1", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "0", "0", "0"]
]
dx = [1,-1,0,0]
dy = [0,0,1,-1]
stack = list() #dfs 구현 위한 스택 리스트 선언

class Solution():
    def numIslands(self, grid):
        self.limitCol = len(grid[0]) # 클래스 내에 변수 선언 불필요. 알아서 선언됩니다.
        self.limitRow = len(grid)

    #     girdVisited = [[False] * len(grid[0]) for _ in range(len(grid))]

    #     for col in range(grid[0]):  # grid 좌표들을 쭉 방문하면서 '1' 랜드인 곳부터 df를 시작한다.
    #         for row in range(grid):
    #             if grid[row][col] == '1':
                    
    
    # def dfs(self,grid,gridVisited,row,col):
    #     for i in range(4):
    #         if 

s = Solution()
s.numIslands(grid)
print(s.limitCol)
