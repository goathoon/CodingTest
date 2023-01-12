def solution(s):
    stack = list()
    for i in range(len(s)):
        if s[i] == '(':
            stack.append(s[i])
        else:
            if not stack:
                return False
            else:
                stack.pop()
    if stack :
        return False
    else :
        return True