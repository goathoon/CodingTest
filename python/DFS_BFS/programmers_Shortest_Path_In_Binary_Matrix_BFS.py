from collections import deque
class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        dx = [1,1,1,0,-1,-1,-1,0]
        dy = [1,0,-1,-1,-1,0,1,1]
        q = deque()
        if grid[0][0] == 0:
            q.append((0,0,1)) #세번째 인자로 거쳐간 블록 수
            grid[0][0] = 1 #방문 체크
        else:
            return -1
        while q:
            pop_idx = q.popleft()
            row,col,ans = pop_idx
            if row == len(grid) -1 and col == len(grid[0]) - 1:
                return ans
            for i in range(8):
                if row + dy[i] < 0 or row +dy[i] >=len(grid) or col+dx[i] <0 or col + dx[i] >=len(grid[0]) or grid[row+dy[i]][col+dx[i]]==1:
                    continue
                q.append((row+dy[i],col+dx[i],ans+1))
                grid[row+dy[i]][col+dx[i]] = 1
        return -1


