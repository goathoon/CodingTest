def solution(answers):
    one = [1,2,3,4,5]
    two = [2,1,2,3,2,4,2,5]
    three = [3,3,1,1,2,2,4,4,5,5]
    answer_cnt = [[1,0],[2,0],[3,0]]
    for i in range(len(answers)):
        one_index = i % 5
        two_index = i % 8
        three_index = i % 10
        if answers[i] == one[one_index] :
            answer_cnt[0][1] += 1
        if answers[i] == two[two_index] :
            answer_cnt[1][1] += 1
        if answers[i] == three[three_index] :
            answer_cnt[2][1] += 1
    answer_cnt.sort(key = lambda x : (-x[1], x[0])) # 먼저 점수 내림차순으로 정렬후 몇번 같을 경우 수포자 번호순으로 오름차순
    answer = []
    answer.append(answer_cnt[0][0])
    if answer_cnt[0][1] == answer_cnt[1][1]:
        answer.append(answer_cnt[1][0])
    if answer_cnt[0][1] == answer_cnt[2][1]:
        answer.append(answer_cnt[2][0])
    return answer

##더러워서 다음거로 할것.
def solution(answers):
    one = [1,2,3,4,5]
    two = [2,1,2,3,2,4,2,5]
    three = [3,3,1,1,2,2,4,4,5,5]
    score =[0,0,0]
    answer = []
    
    for idx,opt in enumerate(answers):
        if one[idx%5] == opt:
            score[0] += 1
        if two[idx%8] == opt:
            score[1] += 1
        if three[idx%10] == opt:
            score[2] += 1
    
    for idx, scr in enumerate(score):
        if max(score) == score[idx]:
            answer.append(idx+1)
    return answer
        
            
