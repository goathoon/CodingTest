from collections import deque

case = int(input())

for _ in range(case):
    func = input().strip()
    cnt = int(input().strip())
    not_arr = input().strip('['']')
    arr = not_arr.split(',')
    if cnt != 0:
        q = deque(arr)
    else:
        q = deque()
    idx = 0
    r_cnt = 0
    while idx < len(func):
        check = False
        if func[idx] == 'R':
            r_cnt += 1

        else:
            if not q:
                check = True
                print("error")
                break
            if r_cnt % 2 == 0:
                q.popleft()
            else:
                q.pop()
        idx += 1
    if check:
        continue
    if r_cnt % 2 == 1:
        q.reverse()

    print("["+",".join(list(q))+"]")
