case = int(input())
for _ in range(case):
    height, number, order = map(int,input().split())
    room_num = (order-1) // height + 1
    room_height = order - height * (room_num-1)
    room_num = format(room_num,'02d')
    print(str(room_height) + room_num)