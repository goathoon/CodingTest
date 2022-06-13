n , k = map(int, input().split())

count = 0
while n != 1 :
    rest = n%k
    count += rest
    n = n - rest
    if n == 0 :
        break
    n = n //k
    count+=1

print(count)
