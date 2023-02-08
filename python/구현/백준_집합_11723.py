import sys

N= int(input())
jh = set()
for _ in range(N):
    
    spl_list = list(sys.stdin.readline().rstrip().split())
    if len(spl_list)==1:
        op = spl_list[0]
    else:
        op,num = spl_list[0],spl_list[1]
    if op=="add":
        jh.add(int(num))
    elif op == "remove":
        jh.discard(int(num))
    elif op =="check":
        if int(num) in jh :
            print(1)
        else:
            print(0)
    elif op =="toggle":
        if int(num) in jh:
            jh.discard(int(num))
        else:
            jh.add(int(num))
    elif op =="all":
        jh.update([i for i in range(1,21)])
    elif op =="empty":
        jh.clear()