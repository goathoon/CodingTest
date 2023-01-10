# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int: #인자의 노드(root)를 subtree의 root 노드로 하는 최대 깊이를 반환
        left_depth = 0
        right_depth = 0
        if not root :
            return 0
        if root.left is None and root.right is None :
            return 1
        if root.left :
            left_depth = 1 + self.maxDepth(root.left)
        if root.right :
            right_depth = 1 + self.maxDepth(root.right)
        return left_depth if left_depth > right_depth else right_depth
        