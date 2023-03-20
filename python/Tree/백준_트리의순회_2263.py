import sys
sys.setrecursionlimit(10**8)
n = int(input())

# 루트 - 왼 - 오


def preorder(inStart, inEnd, postStart, postEnd):
    if inStart > inEnd or postStart > postEnd:
        return
    root = post_order[postEnd]
    print(root, end=' ')
    left_num = position[root] - inStart
    right_num = inEnd - position[root]
    preorder(inStart, inStart+left_num-1, postStart, postStart+left_num-1)
    preorder(inEnd-right_num+1, inEnd, postEnd-right_num, postEnd-1)


# 왼 - 루트 - 오
in_order = list(map(int, input().split()))
# 왼 - 오 - 루트
post_order = list(map(int, input().split()))

position = [0] * (n+1)
for i in range(n):
    position[in_order[i]] = i
preorder(0, n-1, 0, n-1)


"""
재귀함수를 당연히 써야겠다는 생각을 해야만했음.

post의 마지막은 루트노드를 뜻하는 것임을 유의하며,
inorder에서 루트노드의 인덱스를 알면, 왼/오가 나뉨
"""
