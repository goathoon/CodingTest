def solution(N, stages):
    answer = []
    stages.sort()
    stages.append(0) #마지막 원소 있다고 침(에외처리하기 싫어서)
    
    cntArr = [(i,0) for i in range(N+1)] #스테이지 별 실패비율 저장 i번 스테이지 실패율 0
    
    
    cntUser = len(stages) -1 #스테이지마다 총 도전자수 저장
    cntNum = 0 #해당 스테이지 실패한 사람 수
    for i in range(len(stages) - 1): #임의로 삽입한 원소 있기 때문에 -1 함
        cntNum += 1
        if stages[i] == stages[i+1] :
            continue
        else :
            if stages[i] == N + 1:
                break
            cntArr[stages[i]] = (stages[i],cntNum/cntUser)
            cntUser -= cntNum
            cntNum = 0

    cntArr.sort(key = lambda x : -x[1]) #내림차순 그리고 과연 같은 값일 경우 스테이지번호가 오름차순으로 저장이 될까? 순서대로니까 될듯.
    #key를 이용하는 경우 '-' 부호로 내림차순 적용이 가능하다.
    for tup in (cntArr):
        if tup[0] == 0 :
            continue
        answer.append(tup[0])
            
        
        
    return answer