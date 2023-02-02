know, unknown = map(int, input().split())
know_set = set()
unknown_set = set()
for _ in range(know):
    know_set.add(input())
for _ in range(unknown):
    unknown_set.add(input())
ans_set = know_set & unknown_set
print(len(ans_set))
ans_list = list(ans_set)
ans_list.sort()
for i in range(len(ans_set)):
    print(ans_list[i])
