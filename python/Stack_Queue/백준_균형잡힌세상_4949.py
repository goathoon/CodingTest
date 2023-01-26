import sys
input = sys.stdin.readline
while True:
    par_stack = []
    sent = input().rstrip()
    if sent == ".":
        break
    check = True
    for i in range(len(sent)):
        if sent[i] == '(':
            par_stack.append('(')
        elif sent[i] == '[':
            par_stack.append('[')
        elif sent[i] == ')':
            if not par_stack:
                print("no")
                check=False
                break    
            else :
                if par_stack[-1] == '(':    
                    par_stack.pop()
                else :
                    print("no")
                    check=False
                    break
        elif sent[i] == ']':
            if not par_stack:
                print("no")
                check=False
                break
            else :
                if par_stack[-1] == '[':    
                    par_stack.pop()
                else :
                    print("no")
                    check=False
                    break
    if not check:
        continue
    else:
        if par_stack:
            print("no")
        else:
            print("yes")