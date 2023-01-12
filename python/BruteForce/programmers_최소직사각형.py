def solution(sizes):
    maxVal = 0
    for i in range(len(sizes)) :
        if sizes[i][0] < sizes[i][1] :
            sizes[i][1], sizes[i][0] = sizes[i][0], sizes[i][1] #큰 길이부터 앞에
        maxVal = sizes[i][0] if maxVal < sizes[i][0] else maxVal
    minVal = 0
    for i in range(len(sizes)):
        minVal = sizes[i][1] if minVal < sizes[i][1] else minVal
    return maxVal * minVal   