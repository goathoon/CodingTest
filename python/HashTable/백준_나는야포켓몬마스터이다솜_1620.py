import sys
N, question = map(int, sys.stdin.readline().split())
mon_dict = {}

for i in range(1, N+1):
    x = input()
    mon_dict[str(i)] = x
    mon_dict[x] = str(i)

for _ in range(question):
    q = sys.stdin.readline().strip()
    print(mon_dict[q])
