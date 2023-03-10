class Node:
    def __init__(self, val, left, right):
        self.val = val
        self.left = left
        self.right = right


n = int(input())
node_dict = dict()
value, l, r = input().split()
root = Node(value, l, r)
node_dict[value] = root
for _ in range(n-1):
    value, l, r = input().split()
    node = Node(value, l, r)
    node_dict[value] = node


def pre_trav(root):
    print(root, end='')
    value = node_dict[root]
    if value.left == '.' and value.right == '.':
        return
    elif value.left == '.':
        pre_trav(value.right)
    elif value.right == '.':
        pre_trav(value.left)
    else:
        pre_trav(value.left)
        pre_trav(value.right)


pre_trav(root.val)
print('')


def mid_trav(root):
    value = node_dict[root]
    if value.left == '.' and value.right == '.':
        print(root, end='')
        return
    elif value.left == '.':
        print(root, end='')
        mid_trav(value.right)
    elif value.right == '.':
        mid_trav(value.left)
        print(root, end='')
    else:
        mid_trav(value.left)
        print(root, end='')
        mid_trav(value.right)


mid_trav(root.val)
print('')


def post_trav(root):
    value = node_dict[root]
    if value.left == '.' and value.right == '.':
        print(root, end='')
        return
    elif value.left == '.':
        post_trav(value.right)
        print(root, end='')
    elif value.right == '.':
        post_trav(value.left)
        print(root, end='')
    else:
        post_trav(value.left)
        post_trav(value.right)
        print(root, end='')


post_trav(root.val)
