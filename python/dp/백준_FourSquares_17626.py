N = int(input())

arr = [4]* (50001)

for i in range(1,int(50000**(1/2))):
    j = i**2
    arr[j] = 1

for i in range(1,int(50000**(1/2))):
    for j in range(i,int(50000**(1/2))):
        if i**2+j**2 < 50001:
            arr[i**2+j**2] = min(arr[i**2+j**2],2)

for i in range(1,int(50000**(1/2))):
    for j in range(i,int(50000**(1/2))):
        for k in range(j,int(50000**(1/2))):
            if i**2+j**2+k**2 < 50001:
                arr[i**2+j**2+k**2] = min(arr[i**2+j**2+k**2],3)

print(arr[N])