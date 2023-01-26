N =int(input())
if N ==  1:
    print("1")
    exit()
    
sum_all = 1
i = 0
while True:
    sum_all += 6 * i
    if N > sum_all and N <= sum_all + 6 * (i+1) :
        print( i + 2)
        exit()
    i+=1