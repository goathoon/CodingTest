#### 맛보기
x = 15
if x>=10: #이런 식으로 사용한답니다.
    print(x)
score = 85
if score>=90:
    print("학점:A")
elif score >=80:
    print("학점:B")
elif score >=70:
    print("학점:C")
else:
    print("학점:F")

#### 비교 연산자 (상식과 동일합니다. 패스)

#### 논리 연산자
# X and Y / X or Y / not X

#### 기타 연산자
# X in 리스트 / X not in 문자열.

#### 신기한 점 - 조건문의 값이 참이라 해도, 아무것도 처리하고 싶지 않을 떄 pass문을 이용할 수 있음
score = 85
if score>=80:
    pass # 나중에 작성할 소스코드
else :
    print("성적이 80점 미만입니다.")
printf("프로그램을 종료합니다.")

#### 조건문에서 실행될 소스 코드가 한 줄인 경우, 굳이 줄 바꿈을 하지 않고도 간략하게 표현할 수 있다.
score = 85
if score>=80: result ="Success"
else: result = "Fail"

### 조건부 표현식의 활용
score = 85
result = "Success" if score>=80 else "Fail"
print(result)