N = int(input())
length = int(input())
str_io = input()
answer = 0
cnt = 0
idx = 0
while idx < length - 2:
    if str_io[idx:idx+3] == "IOI":
        cnt += 1
        idx += 2
    else:
        idx +=1
        cnt = 0
    if cnt == N:
        answer += 1
        cnt -=1
print(answer)