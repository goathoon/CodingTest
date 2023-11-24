def solution(stones, k):
    max_p = max(stones)+1
    min_p = 0
    
    while min_p <= max_p :
        mid_p = (min_p + max_p) // 2
        cnt = 0
        for s in stones:
            if s - mid_p <= 0:
                cnt += 1
            else:
                cnt = 0
            if cnt >= k :
                break
        if cnt >= k:
            max_p = mid_p - 1
        else:
            min_p = mid_p + 1
    return min_p
        
        