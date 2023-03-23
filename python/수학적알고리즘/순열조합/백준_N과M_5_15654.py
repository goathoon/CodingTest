from itertools import permutations
n, m = map(int, input().split())
arr = list(map(int, input().split()))
for result in permutations(sorted(arr), m):
    result_arr = list(result)
    print(' '.join(map(str, result_arr)))
