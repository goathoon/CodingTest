position = input()
x = int(ord(position[0])) - int(ord('a')) #ord를 활용하여 하나의 문자를 인자로 받고, 해당 문자에 해당하는 유니코드의 정수를 반환한다.
y = int(position[1])
count = 0

dx = [1,2,-1,-2,-1,-2,1,2]
dy = [2,1,-2,-1,2,1,-2,-1]
steps = [(-2,-1),(-1,-2),(1,-2),(2,-1),(2,1),(1,2),(-1,2),(-2,1)]


for step in steps:
    next_x = x+ step[0]
    next_y = y+ step[1]
    if next_x >=0 and next_x<=7 and next_y >=1 and next_y<=8:
        count+=1


print(count)
"""
for i in range(8):
    if x + dx[i] >= 0 and x + dx[i]<8 and y+ dy[i] >=1 and y + dy[i]<=8:
        count+=1
    else :
        continue
    이렇게 해도 됩니다. """