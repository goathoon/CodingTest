def solution(n, lost, reserve):
    answer = n - len(lost) # 일단 lost한 인원들을 전체 수에서 뺌
    lost_set = set(lost)
    reserve.sort()
    reserve_set = set(reserve)
    for people in reserve: 
        print(reserve)
        if people in lost_set :
            lost_set.remove(people)
            reserve_set.remove(people)
            answer += 1
    reserve = list(reserve_set)
    for person in reserve:
        if (person-1) in lost_set:
            lost_set.remove(person-1)
            print(lost_set)
            answer += 1
        elif (person+1) in lost_set:
            lost_set.remove(person+1)
            answer += 1
            
        
        
    return answer