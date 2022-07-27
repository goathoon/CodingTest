def babo(a):
    print(a)
    a-= 1
    if a ==2:
        return
    else:
        babo(a)
babo(5)