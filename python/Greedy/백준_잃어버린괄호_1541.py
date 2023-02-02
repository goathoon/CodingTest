string_list = input().split('-')
num_list = []
for string in string_list:
    num_list.append(string.split('+'))
ans = 0
for index, num in enumerate(num_list):
    hop = 0
    if index == 0:
        for n in num:
            ans += int(n)

    else:  # 각 리스트에 포함된 원소들은 + 로 연결되거나 - 로 죽 연결되어있는 숫자들이다.
        for n in num:
            hop += int(n)
    ans -= hop

print(ans)
