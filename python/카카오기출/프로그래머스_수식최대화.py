from itertools import permutations
import copy
def solution(expression):
    answer = 0
    
    exp = expression.replace('*','+').replace('-','+')
    origin_number_list = exp.split('+')
    origin_op_list = []
    for e in expression:
        if e == '+' or e =='*' or e=='-':
            origin_op_list.append(e)
    permut = list(permutations(['*','+','-'],3))
    
    for p in permut:
        op_list = copy.deepcopy(origin_op_list)
        number_list = copy.deepcopy(origin_number_list)
        for op in p:
            idx = 0
            while idx < len(op_list):
                if op_list[idx] == op:
                    number_list[idx] = cal(op,number_list[idx],number_list[idx+1])
                    del number_list[idx+1]
                    del op_list[idx]
                else:
                    idx += 1
        answer = max(abs(number_list[0]),answer)
    return answer                                

            
                
def cal(op,val1,val2):
    val1 = int(val1)
    val2 = int(val2)
    if op == '*':
        return val1 * val2
    elif op == '+':
        return val1 + val2
    elif op == '-':
        return val1 - val2
        
        