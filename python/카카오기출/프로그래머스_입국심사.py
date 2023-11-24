def solution(n, times):
    right = 1000000000 *  1000000000 
    left = 0
    while left <= right:
        mid = (left + right) // 2
        number = 0
        for t in times:
            number += mid // t
        if number >= n:
            right = mid - 1
        else :
            left = mid + 1
    return left