N,K = map(int, input().split())

count = 0

for i in range(N+1):
    if i <10 :
        x = "0"+str(i)
    else :
        x = str(i)
    for j in range(60):
        if j<10 :
            y = "0" +str(j)
        else :
            y = str(j)
        for k in range(60):
            if k<10 :
                z = "0" +str(k)
            else:
                z = str(k)
            if str(K) in x + y + z:
                count+=1
print(count)
