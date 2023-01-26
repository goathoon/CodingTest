import sys
input = sys.stdin.readline

city = int(input())
bus = int(input())

city_map = [[987654321]*(city+1) for _ in range(city+1)]
for _ in range(bus):
    start,end,cost = map(int,input().split())
    city_map[start][end] = min(city_map[start][end],cost)
for i in range(1,city+1):
    city_map[i][i] = 0
    
#경유 노드 수를 증가시키면서 파악하는 것
for via in range(1,city+1):
    for start in range(1,city+1):
        for end in range(1,city+1):
            city_map[start][end] = min(city_map[start][end],city_map[start][via]+city_map[via][end])

for i in range(1,city+1):
    for j in range(1,city+1):
        if city_map[i][j] == 987654321:
            print(0,end=' ')
        else :
            print(city_map[i][j],end = ' ')
        if j == city:
            print('')