# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.parent = None # parent가 있어야 LCA를 찾을 수 있다는 생각이 들었음

class Solution: 
    def getDepth(self, root:'Treenode', goal:'Treenode',depth): # LCA 를 원하는 노드의 DEPTH를 찾는 과정
        if root is None:
            return 0 #찾는 goal 노드가 존재하지 않음
        
        if root.val == goal.val : 
            return depth
        else:
            if root.right is not None:
                root.right.parent = root #높이를 구하면서 parent까지 저장함
            if root.left is not None:
                root.left.parent = root
            depth += 1 #depth가 재귀에 씌어짐.
            leftResult = self.getDepth(root.left,goal,depth)
            rightResult = self.getDepth(root.right,goal,depth)
            if not leftResult :#왼쪽거 먼저 찾기 이때 값이 false라면, 왼쪽에 원하는 goal노드가 존재하지 않음.
                return rightResult
            else:
                return leftResult
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        depth_p = self.getDepth(root,p,0)
        depth_q = self.getDepth(root,q,0)
        if depth_p > depth_q : # p 와 q 의 높이를 같게 맞추기 위함
            while depth_p != depth_q:
                p = p.parent
                depth_p -= 1
                
        else : #같은거 포함시켜도 상관 없음 어차피 걸림
            while depth_p != depth_q:
                q = q.parent
                depth_q -=1
        
        if p.val == q.val: #lca 찾음. 높이만 맞췄는데, 같을 수 있으니
            return p
        
        else:
            while p.val != q.val:
                p = p.parent
                q = q.parent
            return p
            
            
        
            
        