import itertools

case,target = map(int,input().split())

data = list(map(int,input().split()))

def sum_all(data):
    return data[0] + data[1] + data[2]

low = 987654321
data_comb = 987654321
for x in itertools.combinations(data,3):
    if sum_all(x) <= target :
        low = min(low,target - sum_all(x))
        if low == target-sum_all(x):
            data_comb = sum_all(x)
print(data_comb)
        