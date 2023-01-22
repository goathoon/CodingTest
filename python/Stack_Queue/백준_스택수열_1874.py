N = int(input())
push_list = [0]
answer_list = [0]
answer = []
for _ in range (N):
    ele = int(input())
    last_ele = answer_list[-1]
    last_push = push_list[-1]
    if last_ele < ele:
        while last_ele < ele : #진행중인 스택의 변화를 기록하는 answer_list 스택.
            last_push += 1
            if last_push > ele:
                print("NO")
                exit()
            answer_list.append(last_push)
            push_list.append(last_push)
            last_ele = last_push
            answer.append('+')
        answer_list.pop()
        answer.append('-')
        
    elif last_ele > ele:
        while last_ele > ele:
            last_ele = answer_list.pop()
            answer.append('-')
    else :
        answer_list.pop()
        answer.append('-')
for i in range(len(answer)):
    print(answer[i])
        