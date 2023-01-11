from collections import deque

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int: 
        if not root :
            return 0
        que = deque([(1,root)]) 
        #################################################################################
        #deque인자에는 iterable 객체가 무조건 들어가야함. 안그러면 초기화 안됨에 유의할것#
        #따라서 튜플에 리스트로감쌈 튜플도 iterable하지만, queue선언시 deque((a,b)) 이렇게하면 문제가생기더라
        #################################################################################

        while que:
            height,node = que.popleft() #튜플 꺼낼때 이렇게 할것
            if node.left is not None:
                que.append((height+1,node.left))
            if node.right is not None:
                que.append((height+1,node.right))
        return height