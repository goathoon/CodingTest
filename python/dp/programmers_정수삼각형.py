import copy

def solution(triangle):
    memo = [] #각 층별 거쳐온 최대값을 갱신하는 list
    for i in range(len(triangle) -1):
        for j in range(len(triangle[i])):
            if not memo: #첫번째 인덱스 갱신 (좌우 양쪽)
                memo.append(triangle[i][j] + triangle[i+1][j])
                memo.append(triangle[i][j] + triangle[i+1][j+1])
                continue
            if memo[j] < triangle[i][j] + triangle[i+1][j] :
                memo [j] = triangle[i][j] + triangle[i+1][j]
            memo.append(triangle[i][j] + triangle[i+1][j+1])
        triangle[i+1] = copy.deepcopy(memo) #triangle 층을 최대 값으로 갱신 ->리스트끼리의 등호는 같은 주소값을 가짐 조심해야함. 뒤에 clear로 같이 초기화됨
        memo.clear()
                
    return max(triangle[len(triangle)-1])

# copy 없이 이렇게도 가능 (내가 하려고했던것)
def solution(triangle):
    for t in range(1, len(triangle)):
        for i in range(t+1):
            if i == 0:
                triangle[t][0] += triangle[t-1][0]
            elif i == t:
                triangle[t][-1] += triangle[t-1][-1]
            else:
                triangle[t][i] += max(triangle[t-1][i-1], triangle[t-1][i])
    return max(triangle[-1])
