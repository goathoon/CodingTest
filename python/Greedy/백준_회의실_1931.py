N = int(input())
using_list = []
for _ in range(N):
    start,end = list(map(int,input().split()))
    using_list.append((start,end))
using_list.sort(key=lambda x : (x[1],x[0])) #시작과 종료가 같을수도 있답니다...
answer = 1
end_time = using_list[0][1]
for i in range(1,N):
    if using_list[i][0] >= end_time:
        answer += 1
        end_time = using_list[i][1]
print(answer)
        