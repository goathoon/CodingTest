"""
벽의 경계가 중요하다.
왼쪽벽이 어디까지인가 ,오른쪽벽은 어디까지인가.
그리고 채워진 벽은 쓸모가 없을 것이다.

왼쪽벽과 오른쪽 벽이 어디서 생성되는지 유의깊게 볼 것.

stack에 왼쪽 벽 및 최저 층 index 싹다 저장. 마치 괄호 문제처럼 생각하자. 왼쪽벽이 있고, 오른쪽 벽이 있어야 채워질 수 있다.

그리고, 오른쪽 벽이 생길 때 , 그 즉시 채울 수 있는 공간을 채우자.
"""

class Solution(object):
    def trap(self, height):
        #첫번째 유효한 왼쪽 index(벽) 찾기 
        for i in range(len(height)):
            if height[i] > height[i+1]:
                first_left_index = i
                break

        stack = []
        ans = 0
        lowHeight = -1
        for index in range(first_left_index, 9):
            if height[index] > height[index+1] : #감소 - 왼쪽벽 (내림차 순으로 저장될 것이 자명)
                lowHeight = -1 #아직 최저층이 정해지지 않았음
                if not stack: 
                    stack.append(index)
                
            elif height[index] < height[index+1] and lowHeight == -1: #증가 - 오른쪽 벽 최초로 만들어지는 중, 최초로 증가하는 구간이 생길때=> 각 trap 공간의 최저층 생김
                if not stack : #왼쪽벽이 없이 오른쪽벽이존재할 수 없음
                    continue
                lowHeight = height[index]
                left_index = stack.pop()
                if height[left_index] > height[index+1] : #지금 참조하고 있는 오른쪽 벽의 높이와 stack에 맨 마지막(제일 높이가 낮은) 높이 비교후 물 채우기 
                    ans += (index - left_index) * (height[index+1] - lowHeight)
                    lowHeight = height[index+1]
                    stack.append(left_index) #stack에 다시 push
                    continue #다음 index로 넘어가야함. 오른쪽벽이 채워졌으므로 ->벽기능 상실
                else : #(4,3,5)
                    while height[left_index] < height[index+1]:  #다음 왼쪽벽 높이 꺼내기 ->기존 왼쪽벽은 기능 상실
                        
                        ans += (index - left_index) * (height[left_index] - lowHeight)
                        lowHeight = height[left_index]
                        if not stack:
                            break
                        left_index = stack.pop() 
                    stack.append(index+1) #왼쪽벽이 다 사용되었으면 오른쪽 벽을 왼쪽벽으로 바꿈.
                if not stack : #stack이 비어있으면, 해당 오른쪽 벽 인덱스는 곧 왼쪽 벽이 됨 (기존 왼쪽 벽의 기능상실)
                    stack.append(index+1) #오른쪽벽이 왼쪽벽이 되는 순간

            elif height[index] < height[index+1] :
                left_index = stack.pop()
                if height[left_index] >= height[index+1]:
                    ans += (index - left_index) * (height[index+1] - lowHeight)
                    lowHeight = height[index+1]
                    continue #다음 index로 넘어가야함. 오른쪽벽이 채워졌으므로 ->벽기능 상실
                else :
                    while stack and  height[left_index] < height[index+1]:
                        ans += (index - left_index) * (height[left_index] - lowHeight)
                        lowHeight = height[left_index] - lowHeight
                        left_index = stack.pop()

            else : #같으면 그냥 넘어가자. index만(너비) 중요할 뿐 (같은 층끼리만 물을 채울 것이므로)
                continue 
        return ans



                


            

