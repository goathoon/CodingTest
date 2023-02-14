## 해당 문제는 dp로 풀 수 없습니다. (DAG)상황
up,down = map(int,input().split())
memo = [987654321] * 101

move_dict = {}
for _ in range(up):
    start,end = map(int,input().strip().split())
    move_dict[start] = end
for _ in range(down):
    start,end = map(int,input().strip().split())
    move_dict[start] = end
    
start = 1
end = 100
memo[start] = 0
while start != 100:
    for i in range(1,7):
        if start+i <=100 :
            memo[start+i] = min(memo[start+i],memo[start]+1)
            if start+i in move_dict:
                memo[move_dict[start+i]] = min(memo[start]+1,memo[move_dict[start+i]])
    start += 1  
print(memo[100])