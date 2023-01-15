def solution(n, lost, reserve):
    answer = n - len(lost) # 일단 lost한 인원들을 전체 수에서 뺌
    lost_set = set(lost)
    for index,people in enumerate(reserve): #이렇게하면 index가 밀립니다 ! 조심하세요 !
        if people in lost_set :
            lost_set.remove(people)
            del reserve[index]
            print(reserve)
            answer += 1
    reserve.sort()
    for person in reserve:
        if (person-1) in lost_set:
            lost_set.remove(person-1)
            print(lost_set)
            answer += 1
        elif (person+1) in lost_set:
            lost_set.remove(person+1)
            answer += 1
            
        
        
    return answer