# N = int(input())
# loc  = list(map(int,input().split()))
# cost = 0
# for i in range(len(loc)):
#     cost += loc[i]
# antena_a = cost // N
# antena_b = antena_a + 1

# antena = antena_a if abs(antena_a * N - cost) <= abs(antena_b * N - cost) else antena_b

# print(antena)

#중간값의 존재가 무엇인지 재고하게 만드는 문제. -집의 개수가 중요하다는 점
#평균으로 하게되면 정답이 안되는 경우가 생긴다.
N = int(input())
loc  = list(map(int,input().split()))
loc.sort()

print(loc[(N-1)//2])
