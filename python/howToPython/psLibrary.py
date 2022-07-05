######################## 내장 함수 ########################
# import 명령어 없이 바로 사용할 수 있는 내장함수가 존재
# input(), print()가 그 예시인데 이미 했으므로 skip

#sum
result = sum([1,2,3,4,5]) #iterable 객체, 즉, 반복가능한 객체[리스트,사전 자료형,튜플 자료형 등]가 입력으로 주어졌을 때, 모든 원소의 합을 반환한다.
print(result)

#min
result = min(7,3,5,2)
print(result)

#max
result = max(7,3,5,2)
print(result)

#eval - 수학 수식이 문자열 형식으로 들어오면 해당 수식을 계산한 결과를 반환
result = eval("(3+5) * 7")
print(result)

#sorted - iterable 객체가 들어왔을 떄, 정렬된 결과를 반환
result = sorted([9,1,8,5,4]) #오름차순 정렬
print(result)
result = sorted([9,1,8,5,4],reverse=True) #내림차순 정렬
print(result)

#리스트의 원소로 리스트나 튜플이 존재할 떄 특정 기준에 따라 정렬 수행. 예를들어 key 속성을 이용해 정렬 가능
result = sorted([('홍길동',35), ('이순신',75),('아무개',50)], key = lambda x:x[1], reverse = True) # key 속성( value)를 내림차순으로 정렬
print(result)

#리스트와 같은 iterable 객체는 기본적으로 sort()함수를 내장하고 있어서 굳이 sorted()함수를 사용하지 않아도 됨.
data = [9,1,8,5,4]
data.sort()
print(data)

######################## itertools ########################
# 반복되는 데이터를 처리하는 기능을 포함하고 있는 라이브러리
# 가장 주요한 클래스 (코테에서) permutations 와 combinations이다.
# permutations는 리스트와 같은 iterable 객체에서 r개의 데이터를 뽑아 일렬로 나열하는 모든 경우(순열)을 계산해 준다. 이는 클래스임. 따라서 리스트형으로 변환해야함.
from itertools import permutations
data = ['A','B','C'] #데이터 준비
result = list(permutations(data,3)) #data 중 3 개 뽑아 모든 순열 구하기
print(result)

# combinations 는 permutations에서 조합이 된거임.
from itertools import combinations
data = ['A','B','C']
result = list(combinations(data,2))
print(result)

#product는 중복순열입니다. 이 떄, 뽑는 데이터의 수를 repeat 속성값으로 넣습니다.
from itertools import product
data = ['A','B','C']
result = list(product(data,repeat = 2)) # 2개를 뽑는 중복순열 구하기
print(result)

#combinations_with_replacement는 combinations와 같이 리스트와 같은 iterable 객체에서 r개의 데이터를 뽑아 순서를 고려하지않고 중복을 허용하여 나열하는 모든 조합을 계산. (중복조합)
from itertools import combinations_with_replacement

data = ['A','B','C'] 
result = list(combinations_with_replacement(data,2))
print(result)


# ######################## heapq ########################
# #파이썬의 heap은 Min-Heap 이므로, 단순히 원소를 힙에 넣었다가 빼는 것만으로도 시간 복잡도 O(NlogN)에 오름차순 정렬이 완료된다.

import heapq

def heapsort(iterable):
    h = []
    result = []
    #모든 원소를 차례대로 힙에 삽입
    for value in iterable:
        heapq.heqppush(h,value) #h 에 value값을 차례대로 push.
    #힙에 삽입된 모든 원소를 차례대로 꺼내어 담기
    for _ in range(len(h)):
        result.append(heapq.heappop(h))
    return result

result = heapsort([1,3,5,7,9,2,4,6,8,0])
print(result) #오름차순 정렬됨.

# #파이썬에서는 최대 힙을 제공하지 않음. 따라서 최대 힙을 구현해야 할 떄에는 원소의 부호를 임시로 변경해야 한다. 그후 원위치 하는 방법으로 구현.
import heapq
def heapsort(iterable):
    h = []
    result = []
    #모든 원소를 차례대로 힙에 삽입
    for value in iterable:
        heapq.heappush(h,-value)
    #힙에 삽입된 모든 원소들을 차례대로 꺼내어 담기
    for _ in range(len(h)):
        result.append(-heapq.heappop(h))
    return result
result = heapsort([1,3,5,7,9,2,4,6,8,0])
print(result)

######################## bisect ########################
# 이진 탐색을 위한 라이브러리 이다.
# '정렬된 배열'에서 특정한 원소를 찾아야할 때 매우 효과적.
# 예를 들어 정렬된 리스트 [1,2,4,4,8] 이 있을 떄, 새롭게 데이터 4를 삽입하려 한다고 가정.
# bisect_left(a,4)와 bisect_right(a,4)는 각각 인덱스 값 2와 4를 반환한다. 시간복잡도 O(logN)
# 1 // 2 // 4 // 4 // 8
#       .bisL.    .bisR. 이렇게 선택이 됨. 즉 bisect_left(a,4)와 bisect_right(a,4)는 각각 인덱스값으로 2와 4를 반환한다.
from bisect import bisect_left, bisect_right
a = [1,2,4,4,8]
x = 4
print(bisect_left(a,x))
print(bisect_right(a,x))

#### 값이 특정범위에 속하는 원소의 개수를 구하고자 할 떄 효과적으로 사용될 수 있음. O(logN)으로
from bisect import bisect_left, bisect_right

#값이 [left_value, right_value] 인 데이터 개수를 반환하는 함수
def count_by_range(a,left_value,right_value):
    right_index = bisect_right(a,right_value)
    left_index = bisect_left(a,left_value)
    return right_index - left_index

#리스트 선언
a = [1,2,3,3,3,3,4,4,8,9]
#값이 4인 데이터 개수 출력
print(count_by_range(a,4,4))
#값이 [-1,3] 범위에 있는 데이터 개수 출력
print(count_by_range(a,-1,3))


######################## collections ########################
#### deque ####
# deque 와 counter 가 주로 사용됩니다.
# 파이썬에서는 deque를 활용해 큐를 구현합니다. 별도로 제공되는 Queue 라이브러리가 있는데 일반적인 큐 자료구조를 구현하는 라이브러리는 아니다. 따라서 dequeue를 활용해야함.
# 리스트에서 앞쪽에 원소를 추가,제거할 떄는 O(N)의 시간복잡도가 걸리는데, deque는 O(1)만 걸림.
# 하지만 deque에서는 리스트자료형과 다르게 인덱싱, 슬라이싱등의 기능은 사용할 수 없음. 다만 연속적으로 나열된 데이터의 시작부분이나
# 끝 부분에 데이터를 삽입하거나 삭제할 때에는 매우 효과적으로 사용될 수 있다.

# deque는 스택과 큐의 기능을 모두 포함한다고 할 수 있다.

# deque는 첫 번째 원소를 제거할 때 popleft()를 사용하며,
# 마지막 원소를 제거할 때 pop()을 사용한다.
# 첫 번째 인덱스에 원소 x를 삽입할 때 appendleft(x)를 사용,
# 마지막 인덱스에 원소 x를 삽입할 때 append(x)를 사용

#### 정리하자면, deque를 큐로 사용할 때, 삽입할 떄에는 append()를 사용하고, 원소를 삭제할 때에는, popleft()를 사용
from collections import deque
data = deque([2,3,4])
data.appendleft(1)
data.append(5)

print(data) # deque([1,2,3,4,5])가 출력
print(list(data)) #[1,2,3,4,5]가 출력

#### counter ####
# 등장 횟수를 세는 기능을 합니다.
from collections import Counter
counter = Counter(['red','blue','red','green','blue','blue'])
print(counter['blue']) #'blue'가 등장한 횟수 출력
print(counter['green']) #'green'이 등장한 횟수 출력
print(dict(counter)) #사전 자료형으로 변환. 각 색깔이 keys로 횟수가 values인 dictionary로 변환됨.

######################## math ########################
#### factorial ####
import math
print(math.factorial(5)) #5팩 출력

#### sqrt(x) ####
import math
print(math.sqrt(7)) # 7의 제곱근 출력

#### GCD(최대공약수) ####
import math
print(math.gcd(21,14))

#### 상수 파이, 자연상수 e ####
import math
print(math.pi) #파이 출력
print(math.e) #자연상수 e 출력