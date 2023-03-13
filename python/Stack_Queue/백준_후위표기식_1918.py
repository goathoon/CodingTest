# stack top에 있는 연산자가 현재 연산자보다 우선순위가 높거나 같을 경우, stack.pop() 후 push(stack top >= 현재 연산자)
sik = list(input())
op_list = []
ans = ''
for char in sik:
    if char == '+' or char == '-':
        while op_list and op_list[-1] != '(':
            ans += op_list.pop()  # 괄호안에 포함된 +,-라면 괄호 시작까지 연산자 pop후 +,- append
        op_list.append(char)
    elif char == '*' or char == '/':
        if op_list:
            while op_list[-1] == '*' or op_list[-1] == '/':
                ans += op_list.pop()
                if not op_list:
                    break
        op_list.append(char)
    elif char == '(':
        op_list.append(char)
    elif char == ')':
        while op_list[-1] != '(':
            ans += op_list.pop()
        op_list.pop()
    else:
        ans += char
while op_list:
    ans += op_list.pop()

print(ans)
