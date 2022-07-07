position = input()
x = int(ord(position[0])) - int(ord('a')) #ord를 활용하여 하나의 문자를 인자로 받고, 해당 문자에 해당하는 유니코드의 정수를 반환한다.
y = int(position[1])
count = 0

dx = [1,2,-1,-2,-1,-2,1,2]
dy = [2,1,-2,-1,2,1,-2,-1]

for i in range(8):
    if x + dx[i] >= 0 and x + dx[i]<8 and y+ dy[i] >=1 and y + dy[i]<=8:
        count+=1
    else :
        continue

print(count)