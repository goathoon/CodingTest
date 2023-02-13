from collections import deque
def D(num): 
    num *= 2
    if num >9999:
        num %= 10000
    if num == 0:
        return 0
    return num

def S(num): 
    if num== 0:
        return 9999
    else:
        return num-1

def L(num): 
    front = num % 1000
    back = num // 1000
    return front * 10 + back

def R(num):
    front = num % 10
    back = num // 10
    return front*1000 + back
    


case = int(input())
for _ in range(case):
    start,end = map(int,input().split())
    visit = [0] * 10001
    q = deque()
    q.append((start,''))
    visit[start] = 1
    while q :
        now = q.popleft()
        if now[0] == end:
            print(now[1])
            break
        
        if visit[D(now[0])] == 0:
            q.append((D(now[0]),now[1]+'D'))
            visit[D(now[0])] = 1
        if visit[S(now[0])] == 0:
            q.append((S(now[0]),now[1]+'S'))
            visit[S(now[0])] = 1
        if visit[L(now[0])] == 0:
            q.append((L(now[0]),now[1]+'L'))
            visit[L(now[0])] = 1
        if visit[R(now[0])] == 0:
            q.append((R(now[0]),now[1]+'R'))
            visit[R(now[0])] = 1

        
        


