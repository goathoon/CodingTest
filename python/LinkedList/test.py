import copy
class Node : 
    def __init__(self,data):
        self.data = data

node = Node(2)
copyNode =copy.deepcopy(node)
print(id(node))
print(copyNode.data)