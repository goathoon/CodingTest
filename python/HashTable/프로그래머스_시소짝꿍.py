from collections import Counter
def solution(weights):
    answer = 0

    c = Counter(weights)
    set_weights = list(set(weights)) #중복 제거를 위해서 set로 변환후 list로 다시 변환
    set_weights.sort()
    for i in range(len(set_weights)): 
        one = set_weights[i]
        val = c[one]
        # 무게 같은경우
        if c[one] > 1:
            answer += c[one]*(c[one]-1) //2
        if c[one*3/2] >= 1:
            answer += val * c[one*3/2]
        if c[one*2] >= 1:
            answer += val * c[one*2]
        if c[one*4/3] >= 1:
            answer += val * c[one*4/3]
            
        
    return answer