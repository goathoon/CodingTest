from collections import deque
def solution(progresses, speeds):
    answer = []
    q_p = deque(progresses)
    q_s = deque(speeds)
    
    day = 1
    cnt = 0
    while q_p :
        now = q_p.popleft()
        app_now = q_s.popleft()
        now += day * app_now
        if now >= 100:
            cnt += 1
        else:
            if cnt != 0:
                answer.append(cnt)
                cnt = 0
            while now <100:
                day += 1
                now += app_now
            cnt += 1
        if not q_p:
            answer.append(cnt)
    # thanks
    return answer