from itertools import product

def solution(users, emoticons):
    dc_percent = [10, 20, 30, 40]
    dc_dict = {}
    max_buyer = -1
    max_price = 0
    
    for percent in product(dc_percent,repeat=len(emoticons)):
        percent_idx = 0
        buyer = 0
        total = 0
        for price in emoticons:
            dc_dict[price] = percent[percent_idx]
            percent_idx += 1
    
        for user in users:
            user_price = 0
            percent_dead, price_dead = user[0],user[1]
            for price in emoticons:
                if dc_dict[price] >= percent_dead:
                    user_price += price * ( 1- dc_dict[price] / 100)
                    if user_price >= price_dead:
                        buyer += 1
                        user_price = 0
                        break
            total += user_price
            
        if max_buyer < buyer:
            max_buyer = buyer
            max_price = total
        elif max_buyer == buyer:
            max_price = max(max_price,total)
    
    answer = [max_buyer,max_price]
    return answer