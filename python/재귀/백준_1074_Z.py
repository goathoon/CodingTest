N, row, col = map(int,input().split())
# 분할정복 -> 4사분면으로 잘라서 알맞은 위치에 있는지?
# N이 1씩 증가할 수록 4분면내에 존재하는수는 *4 가됨. 
# 사분면마다 시작하는 수 0,1,2,3 -> 0,4,8,12 -> 0,16,32,48 -> 0,64,128,196

def findFunc(N,ans,row,col):
    if N == 1:
        if row % 2 == 0 and col % 2 == 0 :
            print(ans) 
            return
        elif row % 2 == 0 and col % 2 == 1:
            print(ans+1)
            return
        elif row % 2 == 1 and col % 2 == 0:
            print(ans+2)
            return
        elif row % 2 == 1 and col % 2 == 1:
            print(ans+3)
            return
    if row // 2**(N-1) == 0 and col // 2**(N-1) == 0 :
        findFunc(N-1,ans,row,col)
    elif row // 2**(N-1) == 0 and col // 2**(N-1) == 1:
        col -= 2**(N-1)
        findFunc(N-1,ans+(2**(N-1))**2,row,col)
    elif row // 2**(N-1) == 1 and col // 2**(N-1) == 0 :
        row -= 2**(N-1)
        findFunc(N-1,ans+(2**(N-1))**2*2,row,col)
    elif row // 2**(N-1) == 1 and col // 2**(N-1) == 1 :
        row -= 2**(N-1)
        col -= 2**(N-1)
        findFunc(N-1,ans+(2**(N-1))**2*3,row,col)
    else:
        print(row//2**(N-1),col//2**(N-1))
findFunc(N,0,row,col)