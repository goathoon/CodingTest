def solution(participant, completion):
    dict_part = {}
    dict_comp = {}
    
    for i in range(len(participant)):
        if participant[i] not in dict_part :
            dict_part[participant[i]] = 1
        else :
            dict_part[participant[i]] += 1
    
    for j in range(len(completion)):
        dict_part[completion[j]] -= 1
        if dict_part[completion[j]] == 0:
            del dict_part[completion[j]] #dictionary 삭제하는 방법
    
    
    answer = list(dict_part.keys()) #key값을 list로 바꿔서 하나 출력, 하나씩은 안되는듯. 
    #dictionary.keys() 반환형이 dict_keys의 특별한 JSON형식이라 LIST로 바꿔서 해야하는듯
    return answer[0]