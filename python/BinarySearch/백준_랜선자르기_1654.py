ready, need = map(int,input().split())

line_list = []
for _ in range(ready):
    line_list.append(int(input()))
line_list.sort() #오름차순

longest = line_list[-1]
lowest = 1
answer = 0
max_len = 0
while lowest <= longest:
    make = 0
    mid = (lowest + longest) //2
    for i in range(len(line_list)):
        make += line_list[i] // mid
    if need <= make:
        max_len = max(mid,max_len)
        if max_len == mid:
            answer = max(answer,max_len)
        lowest = mid + 1
    else :
        longest = mid - 1
        
        
print(answer)
        
    
    
