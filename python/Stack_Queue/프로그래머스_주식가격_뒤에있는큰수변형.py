def solution(prices):
    answer = [i for i in range(len(prices)-1, -1, -1)]
    stack = []
    for i in range(len(prices)):
        if not stack or stack[-1][0] <= prices[i]:
            stack.append((prices[i], i))
            continue
        else:
            while stack and stack[-1][0] > prices[i]:
                last_ele = stack.pop()
                answer[last_ele[1]] = i - last_ele[1]
            stack.append((prices[i], i))

    return answer
