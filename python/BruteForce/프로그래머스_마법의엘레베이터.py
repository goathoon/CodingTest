
def solution(storey):
    sheet = []
    dfs(0, storey, sheet)
    return min(sheet)


def dfs(count, num, sheet):
    if num == 0:
        sheet.append(count)
        return
    elif num == 1:
        sheet.append(count+1)
        return
    val = num % 10
    first = val
    dfs(count+first, num//10, sheet)
    second = 10-first
    dfs(count+second, (num+10)//10, sheet)

# 추가 풀이


def solution(storey):
    answer = 0

    while storey:
        div = storey % 10
        if div == 5 and storey//10 % 10 >= 5 or div > 5:
            storey += 10-div
            answer += 10-div
        else:
            answer += div
        storey = storey//10

    return answer
