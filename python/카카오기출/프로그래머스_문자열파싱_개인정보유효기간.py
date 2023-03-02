def solution(today, terms, privacies):
    answer = []
    year = int(today[0:4])
    month = int(today[5:7])
    day = int(today[8:10])
    
    term_dict = {}
    for val in terms:
        app_list = val.split()
        term_dict[app_list[0]] = int(app_list[1])
    print(term_dict)

    for i in range(len(privacies)):
        date,term = privacies[i].split()
        term_year = int(privacies[i][0:4])
        term_month = int(privacies[i][5:7])
        term_day = int(privacies[i][8:10])
        valid_year = term_year
        valid_month = term_month
        valid_day = term_day
        
        valid_day = term_day -1
        check= False
        if valid_day == 0 :

            valid_day = 28
            check=True
            
        if term_month + term_dict[term] / 12 > 1:
            valid_month = (term_month + term_dict[term]) % 12
            valid_year = term_year + (term_month + term_dict[term]) // 12
            if valid_month == 0:
                valid_month = 12
                valid_year -= 1
            if check:
                valid_month -= 1
            
        else:
            valid_month = term_month + term_dict[term]
            
        print(valid_year,valid_month,valid_day)
        if valid_year < year:
            answer.append(i+1)
            continue
        elif valid_year == year and valid_month < month:
            answer.append(i+1)
            continue
        elif valid_year == year and valid_month == month and valid_day < day:
            answer.append(i+1)
            continue
            
    return answer
