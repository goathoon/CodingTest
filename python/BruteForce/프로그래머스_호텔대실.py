def change(time_str):
    return int(time_str[0:2]) * 60 + int(time_str[3:5])


def solution(book_time):
    answer = 0
    avail_list = [0] * 24*60
    for t in book_time:
        start_t = change(t[0])
        end_t = change(t[1]) + 10
        for i in range(start_t, end_t):
            if i > 24*60 - 1:
                break
            avail_list[i] += 1

    return max(avail_list)
