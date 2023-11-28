from itertools import combinations

def solution(friends, gifts):
    f_dict = {}
    no_gift_dict = {}
    give_gift_dict = {}
    answer_dict = {}

    total_list = list(combinations(friends,2))

    for idx in range(len(friends)):
        f_dict[friends[idx]] = [0,0,0]
        friends_list_except_me = set(friends[0:idx] + friends[idx+1:])
        no_gift_dict[friends[idx]] = set(friends_list_except_me)
        give_gift_dict[friends[idx]] = {f : 0 for f in friends_list_except_me}
        answer_dict[friends[idx]] = 0

    for g in gifts:
        [give,take] = g.split(' ')
        f_dict[give][0] += 1
        f_dict[take][1] += 1
        give_gift_dict[give][take] += 1 
        if take in no_gift_dict[give]:
            no_gift_dict[give].remove(take)
        if give in no_gift_dict[take]:
            no_gift_dict[take].remove(give)
    for key in f_dict.keys():
        f_dict[key][2] = f_dict[key][0] - f_dict[key][1]
    
    for case in total_list:
        p1, p2 = case[0],case[1]
        if p2 in no_gift_dict[p1]:
            if f_dict[p1][2] < f_dict[p2][2] :
                answer_dict[p2] += 1
            elif f_dict[p1][2] > f_dict[p2][2]:
                answer_dict[p1] += 1
            else:
                continue
        else:
            if give_gift_dict[p1][p2] < give_gift_dict[p2][p1] :
                answer_dict[p2] += 1
            elif give_gift_dict[p1][p2] > give_gift_dict[p2][p1] :
                answer_dict[p1] += 1
            else:
                if f_dict[p1][2] < f_dict[p2][2] :
                    answer_dict[p2] += 1
                elif f_dict[p1][2] > f_dict[p2][2]:
                    answer_dict[p1] += 1
                else:
                    continue
    answer = -1
    for val in answer_dict.keys():
        answer = max(answer,val)
    return answer
print(solution(["muzi", "ryan", "frodo", "neo"],["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]))