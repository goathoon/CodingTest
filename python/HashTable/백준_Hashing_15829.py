num = int(input())
string = input()
sum_all = 0
for i in range(len(string)):
    sum_all += (ord(string[i]) -96)*31**i
print(sum_all%1234567891)
    