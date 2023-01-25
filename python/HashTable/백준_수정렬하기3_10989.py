case = int(input())
num_dict = {}
for _ in range(case):
    added =int(input())
    if added in num_dict:
        num_dict[added] += 1
    else:
        num_dict[added] = 1
    
dict_list = sorted(num_dict.keys()) #반환형은 리스트이다.
#만약, 딕셔너리의 items를 sorted했다면 튜플자료형을 원소로 하는 리스트가 반환이 된다.
for key in dict_list:
    for _ in range(num_dict[key]):
        print(key)