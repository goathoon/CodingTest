def solution(numbers, target): #numbers 배열로 target을 만들 수 있는 방법의 수를 반환
    answer = 0
    
    if len(numbers) == 1: #target을 만들 수 있는지 마지막 결과를 도출
        if numbers[0] - target == 0 or numbers[0] + target == 0:
            return 1
        else :
            return 0
    
    target = target - numbers[0] #첫번째 index 가 +일 때
    if len(numbers) > 1:
        answer += solution(numbers[1:],target)
    
    target = target + 2* numbers[0] #첫번째 index가 -일 때
    if len(numbers) > 1 :
        answer += solution(numbers[1:],target)
    
    return answer