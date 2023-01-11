N,M = map(int,input().split())
tree = list(map(int,input().split()))
tree.sort()
max_height = tree[-1]
min_height = 0

while min_height<=max_height:
    cut = 0
    mid = (min_height+max_height)//2
    for i in range(len(tree)):
        if tree[i] >= mid:
            cut += tree[i] - mid
    if cut == M:
        print(mid)
        break
    elif cut > M:
        if min_height == max_height:
            print(mid)
            break
        min_height = mid + 1
    else :#아직 M만큼 자르지 못함 그러므로, 해당 높이보다 하나 더 적게 잘라야함
        if min_height == max_height:
            print(mid-1)
            break
        max_height = mid -1
        