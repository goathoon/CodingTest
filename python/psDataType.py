######################## 수 표현 ########################
#### 지수표현들

# 10억의 지수 표현 방식
a = 1e9
print(a)

#752.5
a = 75.25e1
print(a)

#3.954
a = 3954e-3 #3954 * 10^(-3)
print(a)

#### 반올림 (IEEE754 부동소수점 표현의 한계를 대충 극복)
#123.46
print(round(123.456,2)) #소수 셋째(2+1)번쨰 자리에서 반올림. 즉 둘쨰자리까지 표현

#### 수 자료형의 연산
print(a/b) #그저 나누기.
print(a%b) #나머지
print(a//b) #몫
print(a**b) #a^b (거듭제곱)


######################## 리스트 자료형 ########################
# 여러 개의 데이터를 연속적으로 담아 처리하기 위해 사용할 수 있음. 내부적으로는 배열과 동일. 연결 리스트의 자료구조 기능도 포함. append(), remove() 메서드 지원
# c++의 STL vector와 비슷한 경향이 있다.

#### 리스트 만들기
a = [1,2,3,4,5,6,7,8,9]
print(a)

#인덱스 4, 즉 다섯 번쨰 원소에 접근
print(a[4])

#빈 리스트 선언 방법 1)
a = list()
print(a)

#빈 리스트 선언 방법 2)
a = []
print(a)

####실전형 리스트 선언. [크기가 N인 1차원 리스트 모두 0으로 초기화 C++의 memset느낌인가]
n = 10
a = [0] * n
print(a)

####리스트의 인덱싱과 슬라이싱
a = [1,2,3,4,5,6,7,8,9]
#뒤에서 첫 번쨰 원소 출력
print(a[-1])

#뒤에서 세 번쨰 원소 출력
print(a[-3])

#네 번쨰 원소 값 변경
a[3] = 7
print(a)

#두 번쨰 원소부터 네 번쨰 원소까지 출력
print(a[1:4]) # a[1] 부터 a[4-1]까지

#### 리스트 컴프리헨션
# 리스트를 초기화 하는 방법 중 하나. - 대괄호 안에 조건문과 반목문을 넣는 방식으로 리스트를 초기화

# 0부터 19까지의 수 중에서 홀수만 포함하는 리스트
array = [i for i in range(20) if i%2==1]
print(array)

#1부터 9까지의 수의 제곱 값을 포함하는 리스트
array = [i*i for i in range(1,10)]
print(array)

#### 실전형 2차원 리스트 초기화.
n = 3
m = 4
array = [[0]*m for _ in range(n)] #여기서 _(언더바) 는 반복을 수행하되, 반복을 위한 변수의 값을 무시하고자 할 떄 사용.
print(array) #결과값 [[0,0,0,0],[0,0,0,0],[0,0,0,0]]
#### 주의 해야할 2차원 리스트 초기화 (리스트 컴프리헨션을 이용해야 하는 이유?) ####
n = 3
m = 4
array = [[0]*m]*n
print(array)
# [[0,0,0,0],[0,0,0,0],[0,0,0,0]]
array[1][1] = 5
print(array)
# [[0,5,0,0],[0,5,0,0],[0,5,0,0]] 
# 내부적으로 포함된 3개의 리스트가 모두 동일한 객체에 대한 3개의 레퍼런스로 인식되기 때문이다. 따라서 특정한 크기를 가지는 2차원 리스트를 초기화 할 떄에는 리스트 컴프리헨션을 이용.

####리스트 관련 기타 메서드
a = [1,4,3]
print("기본 리스트 : ", a)
#리스트에 원소 삽입
a.append(2) # a = [1,4,3,2] 당연히 시간복잡도는 O(1)
#오름차순 정렬
a.sort()
print("오름차순 정렬:",a) # a = [1,2,3,4] 시간복잡도 O(NlogN)
#내림차순 정렬
a.sort(reverse=True)
print("내림차순 정렬:",a) # a = [4,3,2,1]
#리스트 원소 뒤집기
a.reverse()
print("원소 뒤집기 :",a) # a = [1,2,3,4]
#특정 인덱스에 데이터 추가
a.insert(2,3)
print("인덱스 2에 3추가:",a) # a =[1,2,3,3,4] 시간복잡도 O(N) 남발하면 시간초과 될 수 있음.
#특정 값인 데이터 개수 세기
print("값이 3인 데이터 개수:",a.count(3))
#특정 값 데이터 삭제
a.remove(1)
print("값이 1인 데이터 삭제:",a)
#특정한 값의 원소를 모두 제거하려먼 어떻게 해야할까?
a = [1,2,3,4,5,5,5]
remove_set = {3,5}
#remove_set 에 포함되지 않은 값만을 저장
result = [i for i in a if i not in remove_set] 
print(result)


######################## 문자열 자료형 ########################
#### 문자열 초기화
data = 'Hello World'
print(data)

data = "Don't you knoe \"Python\"?" # '\'는 이스케이프 문자로, 큰따옴표를 출력하는 등의 특별한 목적으로 사용됩니다.
print(data)

#### 문자열 연산
a = "Hello"
b = "World"
print(a + " " +b) #공백을 " "로 포함시킵니다.

#문자열 변수를 양의 정수와 곱하는 경우, 문자열이 그 값만큼 여러 번 더해집니다.
a = "String"
print(a*3) #내부적으로 리스트와 비슷하다는 느낌을 받았을 거에요. 인덱싱과 슬라이싱도 마찬가지로 가능합니다.
#슬라이싱
a = "ABCDEF"
print(a[2:4]) #이러면 뭐가 나오겠어요. C~D까지 나옵니다.

######################## 튜플 자료형 ######################## 그래프 알고리즘에 사용된답니다.
#파이썬의 튜플 자료형은 리스트와 거의 비슷한데, 다음과 같은 차이가 있습니다.

# 1. 튜플은 한 번 선언된 값을 변경할 수 없다.
# 2. 리스트는 대괄호를 이용하지만, 튜플은 소괄호를 이용한다.
# ++.혹여나 자신이 알고리즘을 잘못 작성함으로써 변경하면 안되는 값이 변경되고 있지는 않은지 체크도 가능하답니다.
# ++.또한 튜플은 리스트에비해 상대적으로 효율적으로 공간을 쓸 수 있습니다. 또한, 일반적으로 각 원소의 성질이 서로 다를 때 주로 사용합니다.
#############################################################
a = (1,2,3,4)
print(a) #(1,2,3,4) 가 출력
a[2] = 7 #오류 발생 ->리스트 특징 2번에 위배.


######################## 사전 자료형 ########################
#사전 자료형은 키(KEY) 와 값(VALUE)의 쌍을 데이터로 가지는 자료형입니다. 앞서 다루었던 리스트나 튜플은 값을 순차적으로 저장한다는 특징이 있습니다.
#예를 들어 리스트의 값이 [1,2,3]이라고 한다면, 첫 번쨰 원소는 a[0]으로 1이라는 값을 가짐. 하지만 사전자료형은 키-값 쌍으로 데이터를 가진다.
#파이썬의 사전자료형은 내부적으로 '해시 테이블'을 이용하므로, 기본적으로 데이터의 검색 및 수정에 있어서 O(1)의 시간에 처리 가능. 암튼 리스트보다 훨 빠르다.

data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'
print(data)

#### 사전 자료형에 특정한 원소가 있는지 검사하는 방법
if '사과' in data:
    print("\'사과\'를 키로 가지는 데이터가 존재합니다.")

#### 사전 자료형 관련 함수
data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'
#키 데이터만 담은 리스트
key_list = data.keys()
#값 데이터만 담은 리스트
value_list = data.values()
print(key_list)
print(value_list)
#각 키에 따른 값을 하나씩 출력
for key in key_list:
    print(data[key])

######################## 집합 자료형 ######################## 
#### 집합 자료형 소개
# 1.중복을 허용하지 않는다.
# 2.순서가 없다. ->따라서 인덱싱 불가. (사전형도 마찬가지입니다. 해시테이블임을 다시한번 상기하죠.)
# 특정원소가ㅓ 존재하는지 검사하는 시간복잡도는 사전 자료형과 마찬가지로 O(1)입니다.

#집합 자료형 초기화 방법 1
data = set([1,2,3,4,4,5])
print(data)
#집합 자료형 초기화 방법 2
data = {1,1,2,3,4,4,5}
print(data) #방법1 방법2 결과값은 {1,2,3,4,5}로 같습니다. 원소나열법이라고 생각하시면 되겠네요.

#### 집합 자료형의 연산
a = set([1,2,3,4,5])
b = set([3,4,5,6,7])

print(a|b) #합집합
print(a&b) #교집합
print(a-b) #차집합

#### 집합 자료형 관련 함수
data = set([1,2,3])
print(data)

#새로운 원소 추가
data.add(4) #시간복잡도 O(1)
print(data)

# 새로운 원소 여러 개 추가
data.updata([5,6])
print(data) 

# 특정한 값을 갖는 원소 삭제
data.remove(3) #시간복잡도 O(1)
print(data) 


