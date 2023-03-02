
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
