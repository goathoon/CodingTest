# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
    
class Solution:
    def __init__(self):
        self.answer = list()
        
    def inorderTraversal(self, root):
        if root != None:
            self.inorderTraversal(root.left)
            self.answer.append(root.val)
            self.inorderTraversal(root.right)
        else:
            return
        return self.answer