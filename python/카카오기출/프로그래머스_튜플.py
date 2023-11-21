def solution(s):
    answer = []
    
    num_count_dict = {}
    parse(s[1:-1],num_count_dict)
    number_and_count = list(num_count_dict.values())
    sort_list = sorted(number_and_count,key=lambda val: -val[1])
    for tup in sort_list :
        answer.append(int(tup[0]))                
    
    return answer

def parse(s, num_dict):
    tuples = s[1:-1].split('},{')
    for tup in tuples:
        parse_tup(tup,num_dict)
    
def parse_tup(tup,num_dict):
    numbers = tup.split(',')
    for number in numbers:
        if number in num_dict:
            num_dict[number][1] += 1
        else :
            num_dict[number] = [number,1]
            
    
    
    