from itertools import *
def solution(dice):
    n = len(dice)
    choice = n//2
    idx_list = [i for i in range(0,n)]
    if n >= 4:
        a_idx_case = list(combinations(idx_list,choice))
    else :
        a_idx_case = [[0],[1]]
    
    dice_idx_list = [0,1,2,3,4,5]
    

    print(list(product(dice_idx_list,3)))
    answer = []
    return answer
print(solution([[1, 2, 3, 4, 5, 6], [3, 3, 3, 3, 4, 4], [1, 3, 3, 4, 4, 4], [1, 1, 4, 4, 5, 5]]))