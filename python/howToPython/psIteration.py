######################## while 문 ######################## 
i = 1
result = 0
while i<=9:
    result+= i
    i+=1
print(result)

######################## for 문 ######################## 
#앞선 while문의 맛보기를 for문으로 바꿔 씀
result = 0
for i in range(1,10): #range(시작값,끝 값+1)
    result+=i
print(result)

scores = [90,85,77,65,97]
for i in range(5): #range()의 값을 한개만 넣으면 자동으로 시작값은 0이 됩니다. 여기서는 i가 0~4까지 돕니다.
    if scores[i] >=80:
        print(i+1,"번 학생은 합격입니다.")

#continue 쓴 경우, 프로그램의 흐름을 반복문의 처음으로 돌림. 즉 그친구의 조건문은 무시된다?고 볼 수 있다. (건너 뜀)

scores = [90,85,77,65,97]
cheating_list = {2,4} #set
for i in range(5): #range()의 값을 한개만 넣으면 자동으로 시작값은 0이 됩니다. 여기서는 i가 0~4까지 돕니다.
    if i+1 in cheating_list:
        continue
    if scores[i] >=80:
        print(i+1,"번 학생은 합격입니다.")