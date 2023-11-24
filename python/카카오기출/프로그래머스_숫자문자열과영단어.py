
def solution(s):
    answer = ''
    idx = 0
    s_dict = {'zero':'0', 
            'one':'1',
            'two':'2',
            'three':'3',
            'four':'4',
            'five':'5',
            'six':'6',
           'seven':'7',
           'eight':'8',
           'nine':'9'}
    add = ''
    while idx < len(s):
        if add in s_dict:
            answer += s_dict[add]
            add = ''
        if s[idx].isdigit():
            answer += s[idx]
            idx += 1
        else:
            add += s[idx]
            idx += 1
    if add in s_dict:
        answer += s_dict[add]
    return int(answer)
            
        
            
            