def solution(board):
    O_cnt = 0
    X_cnt = 0

    O_bingo = False
    X_bingo = False

    for col in range(3):
        check = ""
        for row in range(3):
            check += board[row][col]
        if check == "OOO":
            O_bingo = True
        elif check == "XXX":
            X_bingo = True

    check = ""
    check += board[0][0]
    check += board[1][1]
    check += board[2][2]
    if check == "OOO":
        O_bingo = True
    elif check == "XXX":
        X_bingo = True

    check = ""
    check += board[0][2]
    check += board[1][1]
    check += board[2][0]
    if check == "XXX":
        X_bingo = True
    elif check == "OOO":
        O_bingo = True

    for string in board:
        if string == "OOO":
            O_bingo = True
        elif string == "XXX":
            X_bingo = True

        for i in range(3):
            if string[i] == 'O':
                O_cnt += 1
            elif string[i] == 'X':
                X_cnt += 1

    if O_cnt < X_cnt or O_cnt - X_cnt > 1:  # 실수 1번
        return 0

    elif O_bingo and X_bingo:
        return 0
    elif O_bingo and O_cnt - 1 != X_cnt:
        return 0
    elif X_bingo and O_cnt != X_cnt:
        return 0
    elif O_cnt == 0 and X_cnt == 0:
        return 1

    return 1
