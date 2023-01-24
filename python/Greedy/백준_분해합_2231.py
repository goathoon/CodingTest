N = input()
many = len(N)
num = int(N)

start = num- (9 * many) if many > 2 else 0

while start < num + 1:
    sum = 0
    sum += start
    start = str(start)
    for i in range(len(start)):
        sum += int(start[i])
    if sum == num:
        print(start)
        exit(0)
    start = int(start)
    start = start + 1
print(0)
    
