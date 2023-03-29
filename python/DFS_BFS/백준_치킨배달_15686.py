from itertools import combinations
n,m = map(int,input().split())
grid = [[0]*n ]
row = 1
chick_arr=[]
house_arr=[]
for row in range(1,n+1):
    append_list = [0]+list(map(int,input().split()))
    for col,val in enumerate(append_list):
        if val == 2:
            chick_arr.append((row,col)) #치킨 집 정보 위치 저장        
        elif val == 1:
            house_arr.append((row,col))
    grid.append(append_list) 
ans = 987654321
for tup in combinations(chick_arr,m): #튜플형태이다.
    
    for house in house_arr:
        for chick in tup:
            

