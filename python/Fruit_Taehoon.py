#2023.5.7 김태훈
import math

inputMonth = input("월을 입력하세요: " )
inputUserCnt = input("식당 이용자 수: ")

fruitInMonth={
    "Spring2Summer":["strawberry","watermelon"],
    "Fall2Winter":["apple","pear"]
}
fruitAmountPerUser = {
    "strawberry":5,
    "watermelon":0.1,
    "apple":1,
    "pear":0.5
}
def getFruitListByMonth(month):
    if 3<=month<=8:
        return fruitInMonth["Spring2Summer"]
    else:
        return fruitInMonth["Fall2Winter"]
    
def getFruitByDayAndMonth(day,month):
    categoryDay = day % 10
    fruitAtSeason = getFruitListByMonth(month)
    if categoryDay == 1 or categoryDay == 5:
        if "strawberry" in fruitAtSeason:
            return "strawberry"
        elif "apple" in fruitAtSeason:
            return "apple"
        else:
            print("error")
            return ""
    elif categoryDay == 3 or categoryDay == 7:
        if "watermelon" in fruitAtSeason:
            return "watermelon"
        elif "pear" in fruitAtSeason:
            return "pear"
        else:
            print("error")
            return ""

def printSampleOnMonth(month,userCnt):
    totalDay = 30
    for day in range(1,totalDay+1):
        fruitNameByDay = getFruitByDayAndMonth(day,month)
        amountPerDay = math.ceil(fruitAmountPerUser[fruitNameByDay]*userCnt)
        if fruitNameByDay != "":
            print(month,"월 ",day,"일:", fruitNameByDay," ",amountPerDay)
        else:
            print(month,"월 ",day,"일: , -")
            #No Debugging