"""
5
55 5+5 5-5 5/5 5*5
555 55+5 55-5 55/5 55*5 (5+5)+5 (5+5)-5 (5+5)/5 (5+5)*5 (5-5)*5...
시간복잡도 약 4^8 = 2^16 끽해야 (*8해도) 2^19 안됨 10^8 = 2^ 24
"""

def solution(N, number):
    memo = {} #dictionary 정의 -> key = 사용 횟수, value = [key만큼 사용해서 얻어낼 수 있는 사칙연산 결과]
    
    #초기화
    memo[1] = [N]
    memo[2] = [10*N+N,N+N,N//N,N*N]
    if number in memo[1] :
        return 1
    if number in memo[2] :
        return 2
    
    for i in range(3,9): 
        memo[i] = [10**(i-1) * N + memo[i-1][0]] #같은수 N번반복한 NNNN..
        refCnt = i
        for j in range(i//2): # 3이면 1번 2번사용한 memoization을 사용, 5면 1번4번, 2번3번 사용한 memoization 활용
            for refBig in range(len(memo[refCnt-1])):
                for refSmall in range(len(memo[i+1-refCnt])):
                    if memo[refCnt-1][refBig] + memo[i+1-refCnt][refSmall] == number or memo[refCnt-1][refBig] - memo[i+1-refCnt][refSmall] == number or memo[refCnt-1][refBig] * memo[i+1-refCnt][refSmall] == number or memo[refCnt-1][refBig] // memo[i+1-refCnt][refSmall] == number or memo[i+1-refCnt][refSmall] // memo[refCnt-1][refBig] == number or memo[i+1-refCnt][refSmall] - memo[refCnt-1][refBig] == number:
                        return i
                    
                    if memo[refCnt-1][refBig] + memo[i+1-refCnt][refSmall] != 0:
                        memo[i].append(memo[refCnt-1][refBig] + memo[i+1-refCnt][refSmall])
                    if memo[refCnt-1][refBig] - memo[i+1-refCnt][refSmall] != 0:
                        memo[i].append(memo[refCnt-1][refBig] - memo[i+1-refCnt][refSmall])
                        memo[i].append(memo[i+1-refCnt][refSmall] - memo[refCnt-1][refBig])
                    memo[i].append(memo[refCnt-1][refBig] * memo[i+1-refCnt][refSmall])
                    if memo[i+1-refCnt][refSmall] // memo[refCnt-1][refBig] != 0:
                        memo[i].append(memo[i+1-refCnt][refSmall] // memo[refCnt-1][refBig])
                    if memo[refCnt-1][refBig] // memo[i+1-refCnt][refSmall] != 0:
                        memo[i].append(memo[refCnt-1][refBig] // memo[i+1-refCnt][refSmall])
                    
                    
                    
                    
    
    
    
    return -1