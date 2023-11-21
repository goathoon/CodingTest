def solution(gems):
    answer = [0,987654321]
    gem_set = set(gems)
    total_length = len(gem_set)
    gem_dict = {}
    
    l = 0
    r = 0
    
    length = 0
    while True:
        if length == total_length:
            if answer[1] - answer[0] > r - (l  + 1) :
                answer = [l+1,r]
            gem_dict[gems[l]] -= 1
            if gem_dict[gems[l]] == 0:
                length -= 1
                del gem_dict[gems[l]]
            l += 1

        elif length < total_length:
            if r < len(gems) :
                if gems[r] not in gem_dict:
                    gem_dict[gems[r]] = 1
                    length += 1
                    print(length,total_length)
                else:
                    gem_dict[gems[r]] += 1
                r += 1
            else:
                return answer

        
        