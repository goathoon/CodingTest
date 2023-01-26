case = int(input())
for _ in range(case):
    stack = []
    check = True
    paran= input()
    for par in paran:
        if par == '(':
            stack.append('(')
        else:
            if not stack:
                check = False
            else:
                stack.pop()
    if stack or not check:
        print("NO")
    else:
        print("YES")
