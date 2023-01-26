first = 666
n = int(input())

start = 0
while True:
    if "666" in str(first):
        start += 1
    if start == n:
        break
    first += 1
print(first)
    