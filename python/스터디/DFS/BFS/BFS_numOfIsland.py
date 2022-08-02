from collections import deque
class Solution:
    def numIslands(self,grid):
        visited = [[False] * len(grid[0]) for _ in range(len(grid))]
        dx = [1,0,-1,0]
        dy = [0,-1,0,1]
        q = deque()
        count = 0
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == '1' and visited[row][col] == False:
                    q.append((row,col))
                    while(q):
                        f = q.popleft()
                        y = f[0]
                        x = f[1]
                        for i in range(4):
                            if x + dx[i] <0 or x + dx[i] >= len(grid[0]) or y + dy[i] <0 or y+ dy[i] >=len(grid):
                                continue
                            else:
                                if grid[y+dy[i]][x+dx[i]] == '1' and visited[y+dy[i]][x+dx[i]] == False:
                                    q.append((y+dy[i],x+dx[i]))
                                    visited[y+dy[i]][x+dx[i]] = True
                    count += 1 #while 문 빠져나오면서 섬의 갯수 추가. 
        return count
    
grid = [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]  
s = Solution()
print(s.numIslands(grid)) 
                        
                    
    
                