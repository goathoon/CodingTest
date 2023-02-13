case = int(input())
for _ in range(case):
    num = int(input())
    c_dict = {}
    for _ in range(num):
        clothes, kind = input().split()
        if kind not in c_dict:
            c_dict[kind] = 1
        else:
            c_dict[kind] += 1

    ans_list = list(c_dict.keys())
    x = 1
    for val in ans_list:
        x *= (c_dict[val] + 1)
    print(x-1)
