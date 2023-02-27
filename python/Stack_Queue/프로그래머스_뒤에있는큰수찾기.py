# stack이 필요한 이유 ? 뒤의 수에 따라서 앞의 결과값이 달라지기 때문에
def solution(numbers):
    answer = [-1]*len(numbers)
    idx_list = []
    for i in range(len(numbers)):
        value = numbers[i]
        while idx_list and numbers[idx_list[-1]] < value:
            now_idx = idx_list.pop()
            answer[now_idx] = value
        idx_list.append(i)

    return answer
