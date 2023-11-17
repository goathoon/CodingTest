def solution(survey, choices):
    global s_dict
    s_dict = {}
    s_dict[1] = {'R' : 0, 'T' : 0}
    s_dict[2] = {'C' : 0, 'F' : 0}
    s_dict[3] = {'J' : 0, 'M' : 0}
    s_dict[4] = {'A' : 0, 'N' : 0}
    
    global s_mapping
    s_mapping = {}
    s_mapping['R'] = 1
    s_mapping['T'] = 1
    s_mapping['C'] = 2
    s_mapping['F'] = 2
    s_mapping['J'] = 3
    s_mapping['M'] = 3
    s_mapping['A'] = 4
    s_mapping['N'] = 4
    for idx, s in enumerate(survey):
        add_score(idx,s,choices)
    
    answer = ''
    for i in range(1,5):
        answer += get_personality(s_dict[i]) 
    return answer

def add_score(idx,ele,choices):
    num = choices[idx] 
    if num < 4 :
        s_dict[s_mapping[ele[0]]][ele[0]] += 4 - num
    elif num > 4:
        s_dict[s_mapping[ele[1]]][ele[1]] += num - 4
        
def get_personality(s_num):
    s_list = list(s_num.keys())
    if s_num[s_list[0]] >= s_num[s_list[1]]:
        return s_list[0]
    else:
        return s_list[1]
    
    
    