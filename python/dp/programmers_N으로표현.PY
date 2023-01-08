"""
5
55 5+5 5-5 5/5 5*5
555 55+5 55-5 55/5 55*5 (5+5)+5 (5+5)-5 (5+5)/5 (5+5)*5 (5-5)*5...
시간복잡도 약 4^8 = 2^16 끽해야 (*8해도) 2^19 안됨 10^8 = 2^ 24
"""

def solution(N, number):
    memo = {} #dictionary 정의 -> key = 사용 횟수, value = [key만큼 사용해서 얻어낼 수 있는 사칙연산 결과]
    
    #초기화
    memo[1] = {N}
    memo[2] = {10*N+N,N+N,N-N,N//N,N*N}
    if number in memo[1] :
        return 1
    if number in memo[2] :
        return 2
    
    #반복문 중에 set size가 변하면 안됨. 따로 선언 필요 
    first = 10*N+N
    for i in range(3,9): 
        eachSet= set()
        for j in range(i-1,0,-1): 
            refCnt = j
            for refBig in memo[refCnt]:
                for refSmall in memo[i-refCnt]:
                    if refBig + refSmall == number or refBig - refSmall == number or refBig * refSmall == number:
                        return i
                    if refSmall != 0:
                        if refBig // refSmall == number :
                            return i
                    
                    eachSet.add(refBig + refSmall)
                    eachSet.add(refBig - refSmall)
                    eachSet.add(refBig * refSmall)
                    if refSmall != 0:
                        eachSet.add(refBig // refSmall)
                
        first += 10**(i-1) * N #같은수반복한 수 추가
        eachSet.add(first)
        memo[i] = eachSet
                    
                    
                    
    
    
    
    return -1