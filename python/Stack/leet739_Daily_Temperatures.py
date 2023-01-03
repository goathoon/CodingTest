class Solution(object):
    def dailyTemperatures(self, temperatures):
        stack = []
        ans = [0 for i in range(len(temperatures))]
        i = 0
        while i < len(temperatures):
            if not stack:
                stack.append((temperatures[i],i)) #튜플로 온도정보와 index정보 저장
            else:
                while stack and stack[-1][0] < temperatures[i] :
                    index = stack[-1][1]
                    ans[index] = i - index
                    stack.pop()
                stack.append((temperatures[i],i))
            i+=1
        return ans
                        
