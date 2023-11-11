def solution(targets):
    answer = 0
        
    targets.sort(key = lambda target : target[1])
    end_target = 0
    for target in targets:
        if end_target <= target[0]:
            end_target = target[1]
            answer += 1
    return answer