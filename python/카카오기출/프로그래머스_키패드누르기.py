def solution(numbers, hand):
    if hand == "left":
        prior = 'L'
    elif hand == "right":
        prior = 'R'
    l_pointer = '*'
    r_pointer = '#'
    answer = ''
    for n in numbers:
        move_hand = get_hand(n,l_pointer,r_pointer,prior)
        if move_hand == 'R':
            r_pointer = n
        else :
            l_pointer = n
        answer += move_hand
    return answer


        
def get_hand(number,l_pointer,r_pointer,prior):
    if number == 1 or number == 4 or number == 7 :
        return 'L'
    elif number == 3 or number == 6 or number == 9 :
        return 'R'
    else:
        if get_dist(l_pointer,number) < get_dist(r_pointer,number):
            return 'L'
        elif get_dist(l_pointer,number) > get_dist(r_pointer,number):
            return 'R'
        else:
            return prior
        
def get_dist(f,t):
    if t == 2:
        if f == '*' or f == '#':
            return 4
        elif f == 1 or f == 3:
            return 1
        elif f == 4 or f == 6 :
            return 2
        elif f == 7 or f == 9 :
            return 3
        else:
            if f == 2 :
                return 0
            elif f == 5 :
                return 1
            elif f== 8 :
                return 2
            else :
                return 3
        
    elif t == 5:
        if f == '*' or f == '#':
            return 3
        elif f == 1 or f == 3 :
            return 2
        elif f == 4 or f == 6 :
            return 1
        elif f == 7 or f == 9 :
            return 2
        else:
            if f == 2 :
                return 1
            elif f == 5 :
                return 0
            elif f== 8 :
                return 1
            else :
                return 2
        
    elif t == 8 :
        if f == '*' or f == '#':
            return 2
        elif f == 1 or f == 3 :
            return 3
        elif f == 4 or f == 6 :
            return 2
        elif f == 7 or f == 9 :
            return 1
        else:
            if f == 2 :
                return 2
            elif f == 5 :
                return 1
            elif f== 8 :
                return 0
            else :
                return 1
        
    elif t == 0:
        if f == '*' or f == '#':
            return 1
        elif f == 1 or f == 3 :
            return 4
        elif f == 4 or f == 6 :
            return 3
        elif f == 7 or f == 9 :
            return 2
        else:
            if f == 2 :
                return 3
            elif f == 5 :
                return 2
            elif f== 8 :
                return 1
            else :
                return 0
