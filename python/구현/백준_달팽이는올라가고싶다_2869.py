A, B, V = map(int, input().split())

x = (V-A)/(A-B)
if x == int(x):
    print(int(x) + 1)
else:
    print(int(x)+2)