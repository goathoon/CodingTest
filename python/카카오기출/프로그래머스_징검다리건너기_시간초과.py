def solution(stones, k):
    max_p = max(stones)+1
    min_p = 0
    
    while min_p <= max_p :
        mid_p = (min_p + max_p) // 2
        if is_possible(stones,k,mid_p):
            min_p = mid_p + 1
        else:
            max_p = mid_p - 1
    return min_p
        
        

def is_possible(stones,k,mid_p):
    max_count = 0
    count = 0
    for idx in range(len(stones)):
        s_diff = stones[idx] - mid_p
        if s_diff <= 0 :
            count += 1
        else :
            max_count = max(max_count,count)
            count = 0
    max_count = max(max_count,count)
    if max_count >= k : # 이 이후에는 불가
        return False
    else: 
        return True