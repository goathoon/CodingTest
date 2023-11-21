import copy

"""
a = [[1,"2",3,4,5]]
print( [1,"2",3,4,5] in a)
이것도 in으로 검사할 수 있다.

백트래킹시, dfs로 깊은복사를 해야 parameter로 전달되는 변수가 다른 dfs에 영향을 미치지 않는다.
"""

"""
같은 루트 노드 (중간에 같은 user_id와 banned_id) 가 있는경우를 제외함 
해당 코드는

if (copy_uids,copy_bids) not in visit:
visit.append((copy_uids,copy_bids))
dfs(copy_uids,copy_bids,visit)
"""

"""
시간 초과 코드는 다음과 같음
def solution(user_id, banned_id):
    global answer
    answer = 0 
    global is_cand 
    is_cand = set()
    visit = []
    dfs(user_id,banned_id,visit)
    return answer

def dfs(user_id, banned_id,visit):
    global answer
    if len(banned_id) == 0:
        if user_id in visit:
            return
        answer += 1
        visit.append(user_id)
        
    for uid in user_id:
        for bid in banned_id:
            if is_candidate(uid,bid):
                copy_uids = copy.deepcopy(user_id)
                copy_uids.remove(uid)
                copy_bids = copy.deepcopy(banned_id)
                copy_bids.remove(bid)
                dfs(copy_uids,copy_bids,visit)
                    
            
def is_candidate(uid,bid):
    global is_cand
    if (uid,bid) in is_cand:
        return True
    
    if len(uid) != len(bid):
        return False
    for i in range(len(uid)):
        if uid[i] == bid[i] or bid[i] == '*':
            continue
        else:
            return False
    is_cand.add((uid,bid))
    return True
"""
def solution(user_id, banned_id):
    global answer
    answer = 0 
    global is_cand 
    is_cand = set()
    visit = []
    dfs(user_id,banned_id,visit)
    return answer

def dfs(user_id, banned_id,visit):
    global answer
    if len(banned_id) == 0:
        if user_id in visit:
            return
        answer += 1
        visit.append(user_id)
        
    for uid in user_id:
        for bid in banned_id:
            if is_candidate(uid,bid):
                copy_uids = copy.deepcopy(user_id)
                copy_uids.remove(uid)
                copy_bids = copy.deepcopy(banned_id)
                copy_bids.remove(bid)
                if (copy_uids,copy_bids) not in visit:
                    visit.append((copy_uids,copy_bids))
                    dfs(copy_uids,copy_bids,visit)
                    
            
def is_candidate(uid,bid):
    global is_cand
    if (uid,bid) in is_cand:
        return True
    
    if len(uid) != len(bid):
        return False
    for i in range(len(uid)):
        if uid[i] == bid[i] or bid[i] == '*':
            continue
        else:
            return False
    is_cand.add((uid,bid))
    return True